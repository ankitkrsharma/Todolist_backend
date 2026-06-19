package com.todoapp.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoapp.todoapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}