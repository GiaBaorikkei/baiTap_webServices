package com.data.session05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai1Controller {
    @GetMapping("/bai1")
    public String home() {
        return "bai1";
    }
}
