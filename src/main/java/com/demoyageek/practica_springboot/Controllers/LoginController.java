package com.demoyageek.practica_springboot.Controllers;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model, @RequestParam Optional<String> error){
        model.addAttribute("error", error);
        return "/freemarker/login";
    }


}