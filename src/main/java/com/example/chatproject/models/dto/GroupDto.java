package com.example.chatproject.models.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupDto  {
    String groupName;
    String groupDescription;
    String groupPass;
    Boolean isPrivate;
}
