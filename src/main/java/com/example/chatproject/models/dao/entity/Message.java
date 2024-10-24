package com.example.chatproject.models.dao.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Message {
    String message;
    String user;
}
