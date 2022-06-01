package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class AopTestController {
    @ResponseBody
    @GetMapping("/world")
    public String hello(@RequestParam String name){
        return name +" is beautiful";
    }
}
