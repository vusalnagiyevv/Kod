package com.example.TikintiMateriallari.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WishlistController {

    @GetMapping("/favorites")
    public String favorites() {
        return "wishlist/favorites.html";
    }
}
