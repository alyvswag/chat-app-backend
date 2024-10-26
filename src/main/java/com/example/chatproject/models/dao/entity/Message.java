package com.example.chatproject.models.dao.entity;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Message {
    private String message;
    private String user;
}
