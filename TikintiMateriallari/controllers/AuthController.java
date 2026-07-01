package com.example.TikintiMateriallari.controllers;




import com.example.TikintiMateriallari.dtos.auth.RegisterDto;
import com.example.TikintiMateriallari.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;




    @GetMapping("/login")
    public String login(){
        return "auth/login.html";


    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registerDto", new RegisterDto());
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterDto registerDto,BindingResult result, Model model){


        if(result.hasErrors()){
            return "auth/register.html";
        }

        model.addAttribute("registerDto", registerDto);

        userService.register(registerDto);
        return "redirect:/login";
    }



    @GetMapping("/verify")
    public String verify(String token){

        userService.verifyUser(token);


        return "redirect:/login";
    }

}


