package com.example.service;

import com.example.model.FAQ;
import com.example.model.Route;
import com.example.model.RouteDetails;
import com.example.repository.FAQRepository;
import com.example.repository.RouteDetailsRepository;
import com.example.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    FAQRepository faqRepository;
    public void addFAQ(FAQ faq) {
        faqRepository.save(faq);
    }

    public List<FAQ> getAllFAQ() {
       return faqRepository.findAll();
    }
    
    public void deletefaq(int faq)
    {
    	faqRepository.deleteById(faq);
    }


    /*
    verifyPass();
    verifyPassCancellation();
    verifyUserType();

    addPassData();
    removePassData();
    addFAQ()
        deleteFAQ()
            updateFAQ();

*/
}
