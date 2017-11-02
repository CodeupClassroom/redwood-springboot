/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!!";
    }

    @ResponseBody
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!!";
    }

    @ResponseBody
    @GetMapping("/hello/{firstName}/{lastName}")
    public String helloFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return "<h1>Hello, " + firstName + " " + lastName + "!!</h1>";
    }

    // /square/2
    // 4
    @ResponseBody
    @GetMapping("/square/{number}")
    public Double square(@PathVariable Double number) {
        return number *number;
    }
}
