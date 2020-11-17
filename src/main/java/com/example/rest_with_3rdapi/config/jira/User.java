package com.example.rest_with_3rdapi.config.jira;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String self;
    private String name;
    private LoginInfo loginInfo;
}
