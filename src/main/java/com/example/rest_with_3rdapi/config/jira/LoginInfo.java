package com.example.rest_with_3rdapi.config.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private String lastFailedLoginTime;
    private String previousLoginTime;
    private int loginCount;
    private int failedLoginCount;


}
