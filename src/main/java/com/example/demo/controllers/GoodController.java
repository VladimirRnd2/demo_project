package com.example.demo.controllers;

import com.example.demo.services.impl.GoodServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Validated
@RequestMapping("/goods")
public class GoodController {

    private final GoodServiceImpl goodService;

    public GoodController(GoodServiceImpl goodService) {
        this.goodService = goodService;
    }


}
