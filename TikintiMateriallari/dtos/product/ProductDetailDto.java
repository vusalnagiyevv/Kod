package com.example.TikintiMateriallari.dtos.product;

import com.example.TikintiMateriallari.dtos.category.CategoryDto;
import com.example.TikintiMateriallari.dtos.photo.PhotoDto;
import com.example.TikintiMateriallari.models.Photo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {
    private Long id;
    private String name;
    private String slug;
    private BigDecimal price;
    private String description;
    private String shortDescription;
    private String specification;


    private List<PhotoDto> photos;
}
