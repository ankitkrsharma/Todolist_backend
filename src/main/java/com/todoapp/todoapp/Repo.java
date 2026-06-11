package com.todoapp.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Tasks, Long>{

}
