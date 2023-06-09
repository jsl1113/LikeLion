package com.example.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/send")
    public String getForm() {
        return "send";
    }

    @PostMapping("/receive")
    public String receiveData(@RequestParam("message") String message, Model model){
        model.addAttribute("message", message);
        return "receive";
    }
}