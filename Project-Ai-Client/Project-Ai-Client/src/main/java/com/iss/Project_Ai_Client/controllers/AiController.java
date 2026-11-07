package com.iss.Project_Ai_Client.controllers;

import org.springframework.ui.Model;
import com.iss.Project_Ai_Client.services.AiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/ai/")
public class AiController {

    @Autowired
    private AiClientService aiClientService;

    @GetMapping("")
    public String home() {
        return "aihome";
    }

    @PostMapping("/chat")
    public String chat(@RequestParam String prompt, Model model) {

        String response = aiClientService.chat(prompt);

        model.addAttribute("prompt", prompt);
        model.addAttribute("response", response);

        return "aihome";
    }
}
