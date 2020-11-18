package com.example.rest_with_3rdapi.config.controller;

import com.example.rest_with_3rdapi.config.jira.issue.Issue;
import com.example.rest_with_3rdapi.exceptions.IssueException;
import com.example.rest_with_3rdapi.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.rest_with_3rdapi.URLS.CREATE;
import static com.example.rest_with_3rdapi.URLS.ISSUE;

@Controller
@RequiredArgsConstructor
@RequestMapping(ISSUE)
public class IssueController {

    private final IssueService issueService;

    @PostMapping(CREATE)
    public ResponseEntity<String> createIssue(@RequestBody Issue issue) throws IssueException {
        try {
            return ResponseEntity.ok("Issue :" + issueService.createIssue(issue) + " was created");
        } catch (IssueException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/{id}/assignTo={username}")
    public ResponseEntity<String> assignTo(@PathVariable String id, @PathVariable String username) {
        return ResponseEntity.ok(issueService.issueAssignee(id, username));
    }


}