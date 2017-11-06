package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdsController {

    // This is the service placeholder that will be final, that means it will not be changed
    // (it is a error to re-assign to a `final` variable or property)
    private final AdService adSvc;

    // Dependency Injection, everything ties together Services + Controller/ Class
    @Autowired
    public AdsController(AdService adsScv){
        this.adSvc = adsScv;
    }

    @GetMapping("/ads")
    public String showAds(Model vModel){
        vModel.addAttribute("ads", adSvc.findAll());
        return "ads/index";
    }

    /**
     * Note that we have 2 mappings (and methods) for the same path below.
     * While they both have the same path, they have different http methods, GET and POST.
     * This is necessary for the two parts of creating a new ad:
     *
     * 1. show the form for creating an ad -- GET /ads/create
     * 2. submit the form (send the user input to the server) -- POST /ads/create
     */

    @GetMapping("/ads/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("ad", new Ad());
        return "ads/create";
    }

    // Store the ad, then show the index page
    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad ad) {
        adSvc.save(ad);
        // instead of duplicating the logic to show all the ads, we'll just
        // redirect there
        return "redirect:/ads";
    }

}
