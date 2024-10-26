package com.example.chatproject.service.group;

import com.example.chatproject.models.dao.entity.Group;
import com.example.chatproject.service.cipher.AESCBC;
import com.example.chatproject.service.redis.RedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupService {
    private final RedisService redisService;
     Long currentGroupId;
     private final AESCBC cipher;

    public void addGroup(String groupName, String groupDescription, String pass,boolean isPrivate) {
        setCurrentIndex("group");
        redisService.setHashMapForGroup(new Group((currentGroupId+1), groupName, groupDescription, pass,isPrivate));
    }
    private void setCurrentIndex(String key){
        currentGroupId = redisService.currentIndex(key);
    }
    public List<Group> getAllGroup(){
        return redisService.getAllGroup();
    }

    public Boolean checkGroupPassword(long id, String password) {
        return redisService.checkGroupPassword(id,password);
    }
    public Boolean checkGroupName(String groupName) {
        return redisService.checkGroupName(groupName);
    }

    public String getUniqueSearchId(String text) throws Exception{
        return cipher.encrypt(text);
    }

}
