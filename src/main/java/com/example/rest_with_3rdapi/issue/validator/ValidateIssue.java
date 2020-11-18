package com.example.rest_with_3rdapi.issue.validator;


import com.example.rest_with_3rdapi.issue.Issue;
import com.example.rest_with_3rdapi.issue.updateissue.UpdateIssue;
import com.example.rest_with_3rdapi.exceptions.IssueException;

public abstract class ValidateIssue {
    public static boolean validateIssue(Issue issue) throws IssueException {
        if (issue.getFields().getDescription().isEmpty()) {
            throw new IssueException("Discription not found");
        }
        if (issue.getFields().getLabels() == null) {
            throw new IssueException("Labels not found");
        }
        if (issue.getFields().getSummary().isEmpty()) {
            throw new IssueException("summary not found");
        }
        if (issue.getFields().getIssuetype().getName().isEmpty()) {
            throw new IssueException("IssueType name not found");
        }
        if (issue.getFields().getProject().getKey().isEmpty()) {
            throw new IssueException("Project key not found");
        }
        return true;
    }

    public static boolean validateUpdateIssue(UpdateIssue updateIssue) throws IssueException {

        return true;
    }
}