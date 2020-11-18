package com.example.rest_with_3rdapi.service;

import com.example.rest_with_3rdapi.jira.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.example.rest_with_3rdapi.utils.urls.GET_PROJECT;
import static com.example.rest_with_3rdapi.utils.urls.JIRA_BASE_URL;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final JiraService jiraService;
    private final RestTemplate restTemplate;

    public Optional<Project> getProjectByKey(String key){
        jiraService.getSession();
        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("cookie", "JSESSIONID=" + jiraService.sessionValue.getSessionValue());

        HttpEntity request = new HttpEntity<>(header);
        return Optional.ofNullable(restTemplate.exchange(JIRA_BASE_URL + GET_PROJECT + key,
                HttpMethod.GET, request,
                Project.class).getBody());
    }
}
