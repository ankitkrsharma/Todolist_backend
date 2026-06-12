package com.todoapp.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
	@Autowired
	private Repo repo;

	

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
		Tasks existingTask=repo.findById(task.getId()).orElse(null);
		existingTask.setTasks(task.getTasks());
		
		repo.save(existingTask);
		
	}
	
	
	

}
