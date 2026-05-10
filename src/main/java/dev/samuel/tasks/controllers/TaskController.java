package dev.samuel.tasks.controllers;

import dev.samuel.tasks.models.TaskModel;
import dev.samuel.tasks.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskModel> getAll() { return taskService.getAll(); }

    @PostMapping
    public TaskModel save(@RequestBody TaskModel task) { return taskService.save(task); }

    @DeleteMapping("{taskID}")
    public List<TaskModel> delete(@PathVariable UUID taskID) { return taskService.deleteByID(taskID); }

    @PutMapping("{taskID}")
    public  List<TaskModel> update(@PathVariable UUID taskID, @RequestBody TaskModel task){
        return taskService.update(taskID,task);
    }
}
