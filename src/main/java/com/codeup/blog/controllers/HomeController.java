/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. Add controller annotation
@Controller
public class HomeController {
    // 3. Add the response body annotation
    @ResponseBody
    // 4. Bind this method to a url pattern
    @GetMapping("/")
    // 2. Create a regular method for your controller action
    public String showLandingPage() {
        return "This is the landing page!";
    }
}
