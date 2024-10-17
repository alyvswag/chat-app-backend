package com.example.chatproject.service.redis;



import com.example.chatproject.models.dao.entity.Group;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    final RedissonClient redissonClient;


    public void setHashMapForGroup(Group model){
        RMap<Object, Object> map = redissonClient.getMap("group");
        map.put(model.getId(), model);
    }
    public Long currentIndex(String key){
        RMap<Object, Object> map = redissonClient.getMap(key);
       return (long) map.size();

    }

    public List<Group> getAllGroup(){
        RMap<Object, Object> map = redissonClient.getMap("group");
        List<Group> groups = new ArrayList<>();
        for(Object value : map.values()){
            groups.add((Group) value);
        }
        return groups;
    }

    public void set(String tokenName, String token, Long milliSeconds) {
        RBucket<String> key = redissonClient.getBucket(tokenName);
        key.set(token, Duration.of(milliSeconds, ChronoUnit.MILLIS));
    }

    public void addTokensToEmail(String email, String accessToken, String refreshToken) {
        RMap<String, String> tokenMap = redissonClient.getMap(email);
        tokenMap.put("accessToken", accessToken);
        tokenMap.put("refreshToken", refreshToken);
    }

    public void addUserLoginTime(String email) {
        RList<String> loginTimes = redissonClient.getList("loginHistory:" + email);
        loginTimes.add("Giris vaxti: " + new Timestamp(System.currentTimeMillis()));
    }

    public List<String> getUserLoginHistory(String email) {
        RList<String> loginTimes = redissonClient.getList("loginHistory:" + email);
        return loginTimes.readAll();
    }


    public String getRefreshTokenForEmail(String email) {
        RMap<String, String> tokenMap = redissonClient.getMap(email);
        return tokenMap.get("refreshToken");
    }

    public String getAccessTokenForEmail(String email) {
        RMap<String, String> tokenMap = redissonClient.getMap(email);
        return tokenMap.get("accessToken");
    }

    public Boolean exists(String tokenName) {
        RBucket<String> key = redissonClient.getBucket(tokenName);
        return key.isExists();
    }

    public void delete(String tokenName) {
        RBucket<String> key = redissonClient.getBucket(tokenName);
        key.delete();
    }

    public void deleteMap(String email) {
        RMap<String, String> tokenMap = redissonClient.getMap(email);
        tokenMap.delete();
    }

    public Boolean isTokenMine(String email, String refreshToken) {
        RMap<String, String> tokenMap = redissonClient.getMap(email);
        return refreshToken.equals(tokenMap.get("refreshToken"));
    }

}

