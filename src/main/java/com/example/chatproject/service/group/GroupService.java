package com.example.chatproject.service.group;

import com.example.chatproject.models.dao.entity.Group;
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

    public void addGroup(String groupName, String groupDescription, String pass) {
        setCurrentIndex("group");
        redisService.setHashMapForGroup(new Group((currentGroupId+1), groupName, groupDescription, pass));
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
}
