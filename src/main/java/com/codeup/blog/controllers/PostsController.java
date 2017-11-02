/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String showAll(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable int id){
        return "view an individual post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }

}
