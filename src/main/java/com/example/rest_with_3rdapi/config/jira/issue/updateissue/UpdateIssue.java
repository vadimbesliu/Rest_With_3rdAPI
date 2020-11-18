package com.example.rest_with_3rdapi.config.jira.issue.updateissue;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssue {

    @JsonProperty("update")
    private Update update;

}