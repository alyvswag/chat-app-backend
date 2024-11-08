package com.example.chatproject.controller;


import com.example.chatproject.models.dao.entity.Group;
import com.example.chatproject.models.dto.GroupDto;
import com.example.chatproject.service.group.GroupService;
import com.example.chatproject.service.redis.RedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@CrossOrigin
public class GroupController {
    final GroupService groupService;
    private final RedisService redisService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping("/add-group")
    public ResponseEntity<Void> addGroup(@RequestBody GroupDto groupDto) {

        groupService.addGroup(
                groupDto.getGroupName(),
                groupDto.getGroupDescription(),
                groupDto.getGroupPass(),
                groupDto.getIsPrivate());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all-group")
    public ResponseEntity<List<Group>> getAllGroup() {
        return ResponseEntity.ok(groupService.getAllGroup());
    }

    @PostMapping("/check-group-password")
    public ResponseEntity<Boolean> checkGroupPassword(@RequestParam("id") long id,
                                                      @RequestParam("password") String password) {
        return ResponseEntity.ok(groupService.checkGroupPassword(id, password));
    }

    @GetMapping("/get-unique-id")
    public ResponseEntity<String> getUniqueId(@RequestParam("groupName") String text) throws Exception {
        return ResponseEntity.ok(groupService.getUniqueSearchId(text));
    }

    @GetMapping("/check-group-name")
    public ResponseEntity<Boolean> checkGroupName(@RequestParam("groupName") String groupName) {
        return ResponseEntity.ok(redisService.checkGroupName(groupName));
    }

}
