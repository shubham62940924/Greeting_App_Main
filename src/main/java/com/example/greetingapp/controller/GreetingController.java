package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = {"", "/", "/home"})
    public Greeting greeting(@RequestParam(value = "fname", defaultValue = "world") String fname,
                             @RequestParam(value = "lname", defaultValue = "world") String lname) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        return greetingService.addGreeting(user);
    }
}
