package com.todoapp.todoapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoapp.todoapp.dto.LoginRequestDTO;
import com.todoapp.todoapp.models.User;
import com.todoapp.todoapp.services.UserService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @RequestBody User user) {

        user.setId(id);
        userService.updatePassword(user);

        return ResponseEntity.ok("User updated successfully");
        
        
        
    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<String> register(
    		@RequestBody User user
    		){
    	
    	userService.addUser(user);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body("User has been signed in");    	
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(
    		@RequestBody LoginRequestDTO user){
    	
    	userService.validateCreditial(user);
    	
    	
    	
    	
    	return ResponseEntity.status(HttpStatus.OK).body("Login Succesful");
    		
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
}