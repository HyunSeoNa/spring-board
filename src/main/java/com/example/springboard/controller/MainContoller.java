package com.example.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 14.
 * description  :
 */
@Controller
public class MainContoller {

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
}
