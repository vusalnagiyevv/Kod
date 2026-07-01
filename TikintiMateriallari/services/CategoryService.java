package com.example.TikintiMateriallari.services;

import com.example.TikintiMateriallari.dtos.category.*;
import com.example.TikintiMateriallari.models.Category;

import java.util.List;

public interface CategoryService {
    boolean createCategory(CategoryCreateDto categoryCreate);
    boolean updateCategory(Long id, CategoryUpdateDto categoryUpdate);
    List<CategoryDashboardDto> getDashboardCategories();

    CategoryUpdateDto getUpdatedCategory(Long id);

    Category getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();

    List<CategoryPinnedDto> getPinnedCategories();
}
