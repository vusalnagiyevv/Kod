package com.example.TikintiMateriallari.controllers;


import com.example.TikintiMateriallari.dtos.category.CategoryPinnedDto;
import com.example.TikintiMateriallari.dtos.product.ProductPinnedDto;
import com.example.TikintiMateriallari.services.CategoryService;
import com.example.TikintiMateriallari.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String home(Model model) {


        List<CategoryPinnedDto> categoryPinnedDtoList = categoryService.getPinnedCategories();
        List<ProductPinnedDto> productPinnedDtoList = productService.getPinnedProducts();




        model.addAttribute("pinnedCategories", categoryPinnedDtoList);
        model.addAttribute("pinnedProducts", productPinnedDtoList);
        return "index.html";
    }

}
