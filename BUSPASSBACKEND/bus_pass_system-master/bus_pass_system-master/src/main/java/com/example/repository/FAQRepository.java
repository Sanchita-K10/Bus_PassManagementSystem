package com.example.repository;

import com.example.model.FAQ;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FAQRepository extends JpaRepository<FAQ, Integer>
{

	List<FAQ> findAll();

}
