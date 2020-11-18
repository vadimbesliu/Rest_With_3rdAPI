package com.example.rest_with_3rdapi.controller;

import com.example.rest_with_3rdapi.jira.Project;
import com.example.rest_with_3rdapi.exceptions.ProjectException;
import com.example.rest_with_3rdapi.service.JiraService;
import com.example.rest_with_3rdapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final JiraService jiraService;

    @GetMapping("/project/{id}")
    public ResponseEntity<String> getProjectByKey(@PathVariable String id) throws ProjectException {
        jiraService.getSession();
        Optional<Project> projectOptional = projectService.getProjectByKey(id);
        if (projectOptional.isPresent()) {
            return ResponseEntity.ok(projectOptional.get().toString());
        } else {
            throw new ProjectException("Project not found", id);
        }
    }
}
