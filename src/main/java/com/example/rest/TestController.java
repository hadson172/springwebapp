package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO remove this class
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }
}
