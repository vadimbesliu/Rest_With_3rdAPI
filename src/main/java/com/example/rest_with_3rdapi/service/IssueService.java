package com.example.rest_with_3rdapi.service;

import com.example.rest_with_3rdapi.config.jira.issue.Issue;
import com.example.rest_with_3rdapi.config.jira.issue.dto.IssueResponse;
import com.example.rest_with_3rdapi.config.jira.issue.updateissue.Assignee;
import com.example.rest_with_3rdapi.config.jira.issue.validator.ValidateIssue;
import com.example.rest_with_3rdapi.exceptions.IssueException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.rest_with_3rdapi.URLS.CREATE_ISSUE;
import static com.example.rest_with_3rdapi.URLS.JIRA_BASE_URL;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final JiraService jiraService;
    private final RestTemplate restTemplate;

    public String createIssue(Issue issue) throws IssueException {
        ValidateIssue.validateIssue(issue);

        HttpEntity request = new HttpEntity(issue, getHeader());

        return restTemplate.exchange(JIRA_BASE_URL + CREATE_ISSUE,
                HttpMethod.POST,
                request,
                IssueResponse.class).getBody().getId();
    }
    public String issueAssignee(String issueID,String username){
        Assignee assignee = new Assignee(username);

        HttpEntity request = new HttpEntity(assignee,getHeader());

         restTemplate.exchange(JIRA_BASE_URL+CREATE_ISSUE+issueID+"/assignee",
                HttpMethod.PUT,
                request,
                IssueResponse.class);
         return "Assigned to "+ username;
    }

    private HttpHeaders getHeader() {
        jiraService.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + jiraService.sessionValue.getSessionValue());
        return headers;
    }


}
