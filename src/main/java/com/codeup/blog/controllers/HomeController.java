/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. Add controller annotation
@Controller
public class HomeController {
    @GetMapping("/hello/{name}")
    // 2. Create a regular method for your controller action
    public String sayHello(@PathVariable String name, Model viewModel) {
        // This is the replacement for the request method, in order to set attributes in the controller to the view.
        viewModel.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/home")
    public String showIndex() {
        return "home";
    }
}
