package com.cloudops.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "CloudOps Infrastructure Monitoring & Deployment Dashboard is running!";
    }
}