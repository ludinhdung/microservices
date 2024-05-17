package org.taskservice.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private boolean completed;

    private Integer assigneeId;
    private String assigneeName;
    private String assigneeEmail;

    public TaskDetail(String title, String description, boolean completed, Integer assigneeId, String assigneeName, String assigneeEmail) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.assigneeId = assigneeId;
        this.assigneeName = assigneeName;
        this.assigneeEmail = assigneeEmail;
    }
}
