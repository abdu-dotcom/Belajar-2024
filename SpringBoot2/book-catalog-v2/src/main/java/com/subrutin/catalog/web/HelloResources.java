package com.subrutin.catalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResources {

    @GetMapping("/hello")
    public String helloword(@RequestParam(value = "name", defaultValue = "world") String name) {
        return String.format("Hellow %s!",name);
    }
}
