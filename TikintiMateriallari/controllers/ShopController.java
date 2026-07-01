package com.example.TikintiMateriallari.controllers;

import com.example.TikintiMateriallari.dtos.product.ProductDetailDto;
import com.example.TikintiMateriallari.dtos.product.ProductFilterDto;
import com.example.TikintiMateriallari.services.CategoryService;
import com.example.TikintiMateriallari.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("/{category}/{slug}")
    public String detail(@PathVariable String slug, Model model){


        ProductDetailDto productDetailDto = productService.getProductBySlug(slug);
        model.addAttribute("product", productDetailDto);
        return "shop/detail.html";
    }


    @GetMapping("/shop")
    public String shop(Model model, BigDecimal minPrice, BigDecimal maxPrice, String sort, String order, String categorySlug){


        ProductFilterDto productFilterDto = productService.filterProducts(minPrice, maxPrice,sort,order,categorySlug);
        return "shop/shop.html";
    }


}
