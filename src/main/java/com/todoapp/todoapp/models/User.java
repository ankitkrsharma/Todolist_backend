package com.todoapp.todoapp.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(unique=true)    
    private String email;
    private String password;

    @Override
    public String toString() {
        return "User [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", password=" + password + "]";
    }
    
    @OneToMany(mappedBy = "user")
    private List<Tasks> task; 
    
    
    
}