package dev.samuel.tasks.services;

import dev.samuel.tasks.models.TaskModel;
import dev.samuel.tasks.repository.TaskRepository;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // GET
    public List<TaskModel> getAll(){
        Sort sort = Sort.by("title").descending();
        return taskRepository.findAll(sort);
    }

    // POST
    public TaskModel save(TaskModel task){
        if(task.getTitle() == null || task.getTitle().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Title is required.");
        }

        return taskRepository.save(task);
    }

    // DELETE
    public List<TaskModel> deleteByID(UUID taskID){
        if(taskID == null || !taskRepository.existsById(taskID)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Task was not found!");
        }

        taskRepository.deleteById(taskID);
        return getAll();
    }

    // UPDATE
    public List<TaskModel> update(UUID taskID,TaskModel task){
        TaskModel existingTask = taskRepository.findById(taskID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Task was not found!"));

        if(task.getTitle() != null && !task.getTitle().isEmpty()){
            existingTask.setTitle(task.getTitle());
        }

        if(task.getDescription() != null && !task.getDescription().isEmpty()){
            existingTask.setDescription(task.getDescription());
        }

        taskRepository.save(existingTask);

        return getAll();
    }
}
