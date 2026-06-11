package com.todoapp.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@CrossOrigin(origins = "http://localhost:5174")
@Getter
@Setter
@RequiredArgsConstructor

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private Services services;
	
	
	@GetMapping("tasks")
	public List<Tasks> getAllTasks(){
		return services.getAllTasks();
	}
	
	
	@PutMapping("addtasks")
	public void addTask(@RequestBody Tasks task) {
		services.addTask(task);
		
	}
	
	@DeleteMapping("tasks/{id}")
	public void deleteTask(@RequestParam Long id) {
		services.deleteTask(id);
	}
	
	@PutMapping("update")
	public void updateTask(@RequestBody Tasks task) {
		services.updateTask(task);
	}
	
	
}
