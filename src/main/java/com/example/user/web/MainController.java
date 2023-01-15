package com.example.user.web;

import com.example.user.dto.OrderRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

//    @GetMapping("/submit-form")
//    public String createForm(Model model) {
//
//        model.addAttribute("formSubmit", new OrderRequestDto());
//        return "submit-form";
//    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
