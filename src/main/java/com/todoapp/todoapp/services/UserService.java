package com.todoapp.todoapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todoapp.todoapp.dto.LoginRequestDTO;
import com.todoapp.todoapp.exceptions.IncorrectPasswordException;
import com.todoapp.todoapp.exceptions.ResourceNotFoundException;
import com.todoapp.todoapp.exceptions.UserNotFoundException;
import com.todoapp.todoapp.models.User;
import com.todoapp.todoapp.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id)	;
    }

    public void updatePassword(User user) {
    	User existingUser = repository.findById(user.getId())
    		    .orElseThrow(
    		        () -> new ResourceNotFoundException(
    		            "User not found"
    		        )
    		    );
    	
    	existingUser.setPassword(user.getPassword());
    		
        repository.save(existingUser);
    }

	public void validateCreditial(LoginRequestDTO user) {
		// TODO Auto-generated method stub
		
		User existingUser =repository.findByEmail(user.getEmail()).orElseThrow(()->new UserNotFoundException("User with email "+user.getEmail()+ " not found."));
		if(!existingUser.getPassword().equals(user.getPassword())){
			throw new IncorrectPasswordException("Incorrect Password");
		}
				
		
		
	}
}