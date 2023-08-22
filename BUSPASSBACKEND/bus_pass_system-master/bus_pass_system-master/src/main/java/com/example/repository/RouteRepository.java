package com.example.repository;

import com.example.model.FAQ;
import com.example.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer>
{

	List<Route> findAll();
	
	@Modifying
	@Query(value="insert into route (route_name, status) values (:routename, 'Active')", nativeQuery=true)
	int addroute(@Param("routename") String routename);

}
