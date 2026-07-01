package com.example.TikintiMateriallari.controllers;

import com.example.TikintiMateriallari.dtos.basket.BasketAddDto;
import com.example.TikintiMateriallari.dtos.basket.BasketUserDto;
import com.example.TikintiMateriallari.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasketController {


    private final BasketService basketService;


    @GetMapping("/basket")
    @PreAuthorize("isAuthenticated()")
    public String basket(Model model, Principal principal) {
        String email = principal.getName();
        List<BasketUserDto> basketItemUserDtoList = basketService.getBasketItems(email);
        model.addAttribute("baskets", basketItemUserDtoList);
        return "basket/basket.html";
    }


    @PostMapping("/addToCart")
    @PreAuthorize("isAuthenticated()")
    public String addToCart(BasketAddDto basketAddDto, Principal principal){
        String email = principal.getName();
        basketService.createBasketItem(basketAddDto, email);
        return "redirect:/basket";
    }

}
