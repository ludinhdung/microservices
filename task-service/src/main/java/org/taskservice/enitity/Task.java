package org.taskservice.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 255)
    private String title;
    private String description;
    private boolean completed;
    private Integer assignee;

    public Task(String title, String description, boolean completed, Integer assignee) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.assignee = assignee;
    }
}
