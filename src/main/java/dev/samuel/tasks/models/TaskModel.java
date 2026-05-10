package dev.samuel.tasks.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task_table")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskID;
    private String title;
    private String description;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public TaskModel() {
    }

    public TaskModel(UUID taskID, String title, String description, LocalDateTime createdAt) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getTaskId() {
        return taskID;
    }

    public void setTaskId(UUID taskID) {
        this.taskID = taskID;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
