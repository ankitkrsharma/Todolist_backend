package com.todoapp.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tasks")
public class Controller {

    @Autowired
    private Services services;

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return ResponseEntity.ok(services.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Tasks task) {
        services.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task created successfully");
    } // <-- Missing brace was here

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        services.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(
            @PathVariable Long id,
            @RequestBody Tasks task) {

        task.setId(id);
        services.updateTask(task);

        return ResponseEntity.ok("Task updated successfully");
    }
}