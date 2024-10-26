package com.example.chatproject.models.dao.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Group  {
    Long id;
    String groupName;
    String groupDescription;
    String groupPass;
    Boolean isPrivate;
}
