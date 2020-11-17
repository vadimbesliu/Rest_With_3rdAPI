package com.example.rest_with_3rdapi.service;

import com.example.rest_with_3rdapi.config.jira.Credentials;
import com.example.rest_with_3rdapi.config.jira.SessionResponse;
import com.example.rest_with_3rdapi.config.jira.SessionValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.example.rest_with_3rdapi.URLS.CREATE_SESSION_URL;
import static com.example.rest_with_3rdapi.URLS.JIRA_BASE_URL;

@Service
@RequiredArgsConstructor
public class JiraService {
    SessionValue sessionValue = new SessionValue();
    private final RestTemplate restTemplate;
    private final String username = Credentials.username;
    private final String password = Credentials.password;
    public void getSession(){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap();

        body.put("username",username);
        body.put("password",password);

        HttpEntity request = new HttpEntity(body, header);
        sessionValue.setSessionValue(
                restTemplate.postForEntity(JIRA_BASE_URL+
                                CREATE_SESSION_URL,
                        request,
                        SessionResponse.class).getBody().getSession().getValue()
        );
    }
}
