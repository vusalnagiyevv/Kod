package com.example.TikintiMateriallari.controllers.admin;


import com.example.TikintiMateriallari.dtos.category.CategoryDashboardDto;
import com.example.TikintiMateriallari.dtos.category.CategoryDto;
import com.example.TikintiMateriallari.dtos.product.ProductCreateDto;
import com.example.TikintiMateriallari.dtos.product.ProductDashboardDto;
import com.example.TikintiMateriallari.dtos.product.ProductUpdateDto;
import com.example.TikintiMateriallari.services.CategoryService;
import com.example.TikintiMateriallari.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService ProductService;
    private final CategoryService categoryService;

    @GetMapping("/products")
    public String getAll(Model model) {
        List<ProductDashboardDto> productDashboardDtoList = ProductService.getDashboardProducts();
        model.addAttribute("products", productDashboardDtoList);
        return "admin/product/index.html";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();
        model.addAttribute("categories", categoryDtoList);
        return "admin/product/create.html";
    }


    @PostMapping("/product/create")
    public String create(ProductCreateDto productCreate){
        ProductService.createProduct(productCreate);
        return "redirect:/dashboard/products";
    }


    @GetMapping("/product/update/{id}")
    public String update(@PathVariable Long id, Model model){
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();
        model.addAttribute("categories", categoryDtoList);
        ProductUpdateDto ProductUpdateDto = ProductService.getUpdatedProduct(id);
        model.addAttribute("product", ProductUpdateDto);
        return "admin/product/update.html";
    }


    @PostMapping("/product/update/{id}")
    public String update(@PathVariable Long id,ProductUpdateDto ProductUpdate){
        ProductService.updateProduct(id,ProductUpdate);
        return "redirect:/dashboard/products";
    }


}
