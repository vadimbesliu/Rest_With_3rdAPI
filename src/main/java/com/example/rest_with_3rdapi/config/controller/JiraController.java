package com.example.rest_with_3rdapi.config.controller;

import com.example.rest_with_3rdapi.config.jira.User;
import com.example.rest_with_3rdapi.service.JiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.rest_with_3rdapi.URLS.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(CREATE_SESSION)
public class JiraController {
    private final JiraService jiraService;

    @PostMapping(AUTH)
    public ResponseEntity<String> createSession() {
        jiraService.getSession();
        return ResponseEntity.ok("Current session was created");
    }
    @GetMapping(CURRENT_USER)
    public ResponseEntity<ResponseEntity<User>> getUser(){
        return  ResponseEntity.ok(jiraService.getUser());
    }

}
