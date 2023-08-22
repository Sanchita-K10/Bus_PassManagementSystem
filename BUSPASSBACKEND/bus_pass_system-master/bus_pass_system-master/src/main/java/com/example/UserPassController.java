package com.example;

import com.example.model.User;
import com.example.model.UserPass;
import com.example.service.UserPassService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:3000")
@ControllerAdvice
public class UserPassController
{
    @Autowired
    UserPassService userPassService;

    @Autowired
    UserService userService;
    @PostMapping("/addpass")
    public ResponseEntity issuePass(@RequestBody UserPass userPass,@RequestParam("userId") Long userId,@RequestParam("routeId") Integer routeId)
    {
        Optional<User> validUser = userService.getUser(userId);
        if(validUser.isPresent()) {
            userPassService.createNewPass(userPass, validUser.get(),routeId);
            return new ResponseEntity<>("User pass created Successfully", HttpStatus.OK);

        }
        return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/updatepass")
    public ResponseEntity updatePass(@RequestBody UserPass userPass,@RequestParam("userId") Long userId)
    {
        Optional<User> validUser = userService.getUser(userId);
        if(validUser.isPresent()) {
            userPassService.updatePass(userPass, validUser.get());
            return new ResponseEntity<>("User pass updated Successfully", HttpStatus.OK);

        }
        return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/pass/{passId}")
    public ResponseEntity updatePass(@PathVariable("passId") Integer passId)
    {
            Optional<UserPass> pass = userPassService.getPass(passId);
            if(pass.isPresent())
            return new ResponseEntity<>(pass.get(), HttpStatus.OK);
        else
        return new ResponseEntity<>("No Pass found with passId "+passId, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/passes")
    public ResponseEntity getPassesForApproval()
    {
        List<UserPass> passesForApproval = userPassService.getAllPassesForApproval();
        if(passesForApproval.isEmpty())
            return new ResponseEntity<>("No Pass found for approvals", HttpStatus.BAD_REQUEST);
        else

            return new ResponseEntity<>(passesForApproval, HttpStatus.OK);
    }
    
    @GetMapping("/allpasses")
    public ResponseEntity getAllPasess()
    {
    	List<UserPass> allpass = userPassService.getAllPasses();
    	return new ResponseEntity<>(allpass, HttpStatus.OK);
    }
    
    @GetMapping("/allpendingrequest")
    public ResponseEntity getAllPending()
    {
    	List<User> allpass = userService.getAllPending();
    	return new ResponseEntity<>(allpass, HttpStatus.OK);
    }
}
