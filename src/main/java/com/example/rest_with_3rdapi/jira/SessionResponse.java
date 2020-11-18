package com.example.rest_with_3rdapi.jira;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponse {

    private LoginInfo loginInfo;
    private Session session;

}
