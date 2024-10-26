package com.example.chatproject.controller;

import com.example.chatproject.models.dao.entity.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Message sendMsg(@DestinationVariable String roomId, Message msg) {
        System.out.println("otaq adi : "+roomId);
        System.out.println( "user: "+ msg.getUser() + " message: "  + msg.getMessage() );
        return new Message( msg.getMessage(), msg.getUser());
    }




}

