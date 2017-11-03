package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showPage(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String play(@PathVariable Integer guess, Model vModel){

        int rnd = (int) (Math.random() * 6 + 1);

        vModel.addAttribute("guess", guess);
        vModel.addAttribute("rnd", rnd);

        return "roll-dice";
    }

}
