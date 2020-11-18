package com.example.rest_with_3rdapi.service;

import com.example.rest_with_3rdapi.jira.Credentials;
import com.example.rest_with_3rdapi.jira.SessionResponse;
import com.example.rest_with_3rdapi.jira.SessionValue;
import com.example.rest_with_3rdapi.jira.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.example.rest_with_3rdapi.utils.urls.*;

@Service
@RequiredArgsConstructor
public class JiraService {
    SessionValue sessionValue = new SessionValue();
    private final RestTemplate restTemplate;
    private final String username = Credentials.username;
    private final String password = Credentials.password;

    public void getSession() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap();

        body.put("username", username);
        body.put("password", password);

        HttpEntity request = new HttpEntity(body, header);
        sessionValue.setSessionValue(
                restTemplate.postForEntity(JIRA_BASE_URL +
                                CREATE_SESSION_URL,
                        request,
                        SessionResponse.class).getBody().getSession().getValue()
        );
    }

    public ResponseEntity<User> getUser() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("cookie","JSESSIONID="+sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(header);
        return restTemplate.exchange(JIRA_BASE_URL+GET_CURRENT_USER, HttpMethod.GET,request, User.class);
    }

}
