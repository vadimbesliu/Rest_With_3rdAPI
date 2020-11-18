package com.example.rest_with_3rdapi.issue.updateissue;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;
}