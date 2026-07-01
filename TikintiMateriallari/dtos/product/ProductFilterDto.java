package com.example.TikintiMateriallari.dtos.product;

import com.example.TikintiMateriallari.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterDto {
    private Long id;
    private String slug;
    private String name;
    private BigDecimal price;
    private String photoUrl;
}
