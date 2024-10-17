package com.example.chatproject.models.dao.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;
    String firstName;
    String lastName;
}
