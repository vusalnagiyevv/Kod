package com.example.TikintiMateriallari.controllers.admin;


import com.example.TikintiMateriallari.dtos.category.CategoryCreateDto;
import com.example.TikintiMateriallari.dtos.category.CategoryDashboardDto;
import com.example.TikintiMateriallari.dtos.category.CategoryUpdateDto;
import com.example.TikintiMateriallari.services.CategoryService;
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
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String getAll(Model model) {
        List<CategoryDashboardDto> categoryDashboardDtoList = categoryService.getDashboardCategories();
        model.addAttribute("categories", categoryDashboardDtoList);
        return "admin/category/index.html";
    }

    @GetMapping("/category/create")
    public String create(){


        return "admin/category/create.html";
    }


    @PostMapping("/category/create")
    public String create(CategoryCreateDto categoryCreate){

        categoryService.createCategory(categoryCreate);


        return "redirect:/dashboard/categories";
    }


    @GetMapping("/category/update/{id}")
    public String update(@PathVariable Long id, Model model){
        CategoryUpdateDto categoryUpdateDto = categoryService.getUpdatedCategory(id);
        model.addAttribute("category", categoryUpdateDto);
        return "admin/category/update.html";
    }


    @PostMapping("/category/update/{id}")
    public String update(@PathVariable Long id,CategoryUpdateDto categoryUpdate){
        categoryService.updateCategory(id,categoryUpdate);
        return "redirect:/dashboard/categories";
    }


}
