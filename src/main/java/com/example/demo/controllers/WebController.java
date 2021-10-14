package com.example.demo.controllers;


import com.example.demo.models.dto.OrderDTO;
import com.example.demo.services.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        return "index.html";
    }

    @GetMapping("/javascript")
    public String javascript() {
        return  "javascript.js";
    }
}
