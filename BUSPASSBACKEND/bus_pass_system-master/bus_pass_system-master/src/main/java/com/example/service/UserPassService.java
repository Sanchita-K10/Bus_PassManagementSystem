package com.example.service;

import com.example.model.*;
import com.example.repository.RouteDetailsRepository;
import com.example.repository.RouteRepository;
import com.example.repository.UserPassRepository;
import com.example.repository.UserRepository;
import com.example.utils.PassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPassService {

    @Autowired
    UserPassRepository userPassRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    RouteDetailsRepository routeDetailsRepository;

    @Autowired
    UserService userService;
    public void createNewPass(UserPass userPass, User user,Integer routeId) {
        Optional<Route> route = routeRepository.findById(routeId);
        userPass.setRoute(route.get());
        userPass.setUser(user);
        userPass.setPassCost(calculatePassPrice(userPass,user));
        userPass.setStatus("active");
        userPassRepository.save(userPass);
    }

    private Long calculatePassPrice(UserPass userPass, User user) {
        int roi = 0;
        if(user.isTypeVerified()){
            roi = userService.getUserTypeDiscount(user.getType());
        }
        RouteDetails source = routeDetailsRepository.findByStation(userPass.getSource()).get();
        RouteDetails destination = routeDetailsRepository.findByStation(userPass.getDestination()).get();
        PassType monthly = PassType.valueOf(userPass.getPassType());
        Long totalprice  = (long) ((destination.getDistance() - source.getDistance())*2* monthly.getDays());
        Long cost = totalprice - ((totalprice*roi)/100);
        return  cost;
    }

    public Optional<UserPass> getPass(Integer passId) {
       return  userPassRepository.findById(passId);
    }

    public List<UserPass> getAllPassesForApproval() {
        return userPassRepository.findAllByStatus("PENDING FOR APPROVAL");
    }

    public void updatePass(UserPass userPass, User user) {
            userPass.setUser(user);
            userPassRepository.save(userPass);
    }

    public void processPayment(UserPass userPass){
    //TODO: add payment processing logic here
    }
    
    public List<UserPass> getAllPasses()
	{
		return userPassRepository.findAll();
	}

	
}
