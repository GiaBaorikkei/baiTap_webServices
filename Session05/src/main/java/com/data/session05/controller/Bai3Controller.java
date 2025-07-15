package com.data.session05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai3Controller {
    @GetMapping("/bai3")
    public String home() {
        return "bai3";
    }
}
