package com.example;

import com.example.model.FAQ;
import com.example.model.User;
import com.example.model.UserPass;
import com.example.repository.FAQRepository;
import com.example.service.AdminService;
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
@RequestMapping("/FAQService")
@CrossOrigin(origins = "http://localhost:3000")
@ControllerAdvice
public class FAQController
{
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    @PostMapping("/addFaq")
    public ResponseEntity addFAQ(@RequestBody FAQ faq, @RequestParam("userId") int userId)
    {
        Optional<User> user = userService.isAdmin((long)userId);
        if(user.isEmpty())
        return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
        else
            adminService.addFAQ(faq);

         return new ResponseEntity<>("FAQ added Successfully", HttpStatus.OK);
    }


    @PutMapping("/updateFaq")
    public ResponseEntity updateFAQ(@RequestBody FAQ faq,@RequestParam("userId") Long userId)
    {
        Optional<User> user = userService.isAdmin(userId);
        if(user.isEmpty())
            return new ResponseEntity<>("Invalid user", HttpStatus.BAD_REQUEST);
        else
            adminService.addFAQ(faq);

        return new ResponseEntity<>("FAQ added Successfully", HttpStatus.OK);
    }
    @GetMapping("/faqs")
    public ResponseEntity getAllFAQ()
    {
        List<FAQ> faqs = adminService.getAllFAQ();
        if (faqs.isEmpty())
            return new ResponseEntity<>("FAQ not found", HttpStatus.OK);
        return new ResponseEntity<>(faqs, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteFaq")
    public ResponseEntity deleteFaq(@RequestParam("faqId") int faqId)
    {
    	adminService.deletefaq(faqId);
    	return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }

}
