package com.todoapp.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.todoapp.models.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long>{

}
