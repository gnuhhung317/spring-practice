package net.hung.thymeleaf_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World");
        return "hello-world";
    }
}
