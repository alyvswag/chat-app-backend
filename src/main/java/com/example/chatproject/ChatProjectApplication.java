package com.example.chatproject;

import com.example.chatproject.models.dao.entity.Group;
import com.example.chatproject.service.redis.RedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatProjectApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ChatProjectApplication.class, args);
    }
//
//    @Autowired
//    RedisService redisService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        System.out.println(redisService.getAllGroup());
//    }


}
