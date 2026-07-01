package com.example.TikintiMateriallari.dtos.category;

import com.example.TikintiMateriallari.dtos.product.ProductPinnedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPinnedDto {
    private Long id;
    private String name;
    private String slug;
    private List<ProductPinnedDto> products;
}
