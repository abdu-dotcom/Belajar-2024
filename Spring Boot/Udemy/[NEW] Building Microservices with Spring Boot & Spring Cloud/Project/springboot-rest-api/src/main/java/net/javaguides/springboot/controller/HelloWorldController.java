package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // HTTP Get Request
    // http://localhost:8081/hello
    @GetMapping("hello")
    public String helloWord() {
        return "Hello World";
    }
}
