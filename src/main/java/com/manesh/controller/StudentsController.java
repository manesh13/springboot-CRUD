package com.manesh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
    @GetMapping("/")
    public String index(){
        return "DEMO APP";
    }
}
