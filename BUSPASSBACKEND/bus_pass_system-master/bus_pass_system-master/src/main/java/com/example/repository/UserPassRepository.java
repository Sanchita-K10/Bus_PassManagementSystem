package com.example.repository;

import com.example.model.User;
import com.example.model.UserPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserPassRepository extends JpaRepository<UserPass, Integer>
{
    List<UserPass> findAllByStatus(String status);
    
    
	
}
