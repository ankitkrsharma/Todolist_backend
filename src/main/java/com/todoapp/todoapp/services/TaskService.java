package com.todoapp.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.todoapp.models.Tasks;
import com.todoapp.todoapp.repositories.TaskRepository;

@Service
public class TaskService{

    @Autowired
	private TaskRepository repo;

	

	public List<Tasks> getAllTasks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	public void addTask(Tasks task) {
		// TODO Auto-generated method stub
		
		repo.save(task);
		
	}



	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		Tasks task= repo.findById(id).orElse(null);
		
		repo.delete(task);
		
		
	}



	public void updateTask(Tasks task) {
		// TODO Auto-generated method stub
		System.out.println("input-> "+task);
		Tasks existingTask=repo.findById(task.getId()).orElse(null);
	
		existingTask.setTasks(task.getTasks());
		existingTask.setStatus(task.getStatus());
		
		repo.save(existingTask);
		
	}
	
	
	

}
