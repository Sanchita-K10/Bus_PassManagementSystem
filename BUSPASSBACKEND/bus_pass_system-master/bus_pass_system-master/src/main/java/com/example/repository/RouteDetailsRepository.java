package com.example.repository;

import com.example.model.Route;
import com.example.model.RouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteDetailsRepository extends JpaRepository<RouteDetails, Integer>
{

	List<RouteDetails> findAll();

	List<RouteDetails> findAllByRoute(Route route);
	Optional<RouteDetails> findByStation(String station);

}
