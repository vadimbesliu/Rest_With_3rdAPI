package com.example.rest_with_3rdapi.config.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private static final long serialVersionUID = 331L;
    private String expand;
    private String self;
    private String id;
    private String key;
    private String name;
    private String projectTypeKey;
    @Override
    public String toString() {
        return "Project{" +
                "expand='" + expand + '\'' +
                ", self='" + self + '\'' +
                ", id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", projectTypeKey='" + projectTypeKey + '\'' +
                '}';
    }
}
