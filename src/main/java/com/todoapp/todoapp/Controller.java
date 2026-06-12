package com.todoapp.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@CrossOrigin(origins = "http://localhost:5174")

@RestController
@RequestMapping("/tasks")
public class Controller {
	
	@Autowired
	private Services services;
	
	
	@GetMapping
	public List<Tasks> getAllTasks(){
		return services.getAllTasks();
	}
	
	
	@PostMapping
	public void addTask(@RequestBody Tasks task) {
		services.addTask(task);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		services.deleteTask(id);
	}
	
	@PutMapping("/{id}")
	public void updateTask(@PathVariable Long id,  @RequestBody Tasks task) {
		task.setId(id);
		services.updateTask(task);
	}
	
	
}
