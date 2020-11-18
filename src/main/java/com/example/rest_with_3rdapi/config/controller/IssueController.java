package com.example.rest_with_3rdapi.config.controller;

import com.example.rest_with_3rdapi.config.jira.issue.Issue;
import com.example.rest_with_3rdapi.config.jira.issue.updateissue.Comment;
import com.example.rest_with_3rdapi.config.jira.issue.updateissue.UpdateIssue;
import com.example.rest_with_3rdapi.exceptions.IssueException;
import com.example.rest_with_3rdapi.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.example.rest_with_3rdapi.URLS.*;

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

    @PostMapping(ASSIGNED_TO_USER)
    public ResponseEntity<String> assignTo(@PathVariable String id, @PathVariable String username) {
        return ResponseEntity.ok(issueService.issueAssignee(id, username));
    }

    @PutMapping(ISSUE_UPDATE)
    public ResponseEntity<String> updateIssue(@PathVariable String id, @RequestBody UpdateIssue updateIssue) {
        try {
            return ResponseEntity.ok("Status :" + issueService.updateIssue(updateIssue, id) + " Issue was updated");
        } catch (IssueException issueException) {
            issueException.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(issueException.getMessage());
        }
    }

    @PostMapping(ADD_COMMENT)
    public ResponseEntity<String> addComment(@PathVariable String id, @RequestBody Comment comment) {
        return ResponseEntity.ok(issueService.addComment(id, comment));
    }

    @DeleteMapping(DELETE_COMMENT)
    public ResponseEntity<String> deleteComment(@PathVariable String id, @PathVariable String commentID) {
        return ResponseEntity.ok(issueService.deleteComment(id, commentID));
    }

    @DeleteMapping(ID)
    public ResponseEntity<String> deleteIssue(@PathVariable String id) {
        return ResponseEntity.ok(issueService.deleteIssue(id));
    }

}