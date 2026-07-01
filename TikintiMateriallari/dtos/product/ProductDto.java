package com.example.TikintiMateriallari.dtos.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String slug;
    private BigDecimal price;
    private String photoUrl;
}
