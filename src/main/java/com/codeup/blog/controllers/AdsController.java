package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// We created this class and method just to test it in java, without any views yet.
@Controller
public class AdsController {

    // This is the service placeholder that will be final, that means it wil, not be changed
    private final AdService adSvc;

    // Dependency Injection, everything ties together Services + Controller/ Class
    @Autowired
    public AdsController(AdService adsScv){
        this.adSvc = adsScv;
    }

    // Basic tests for the dependency injection and how the methods works with a controller
    @GetMapping("/ads")
    @ResponseBody
    public String showAds(){
        String output = "";

        // Adds a new add just with the title and desc using the save method from the Service
        adSvc.save(new Ad("New title", "new desc"));

        // Gets all the ads from the findAll method
        List<Ad> ads = adSvc.findAll();

        // tests to see if we get the lists or not using basic HTML, do this with an actual view
        for (Ad ad: ads) {
            output += ad.getTitle() + "<br/>"+ ad.getDescription()+ "<br/>";
        }

        return output;
    }


}
