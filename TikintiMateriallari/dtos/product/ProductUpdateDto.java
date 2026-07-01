package com.example.TikintiMateriallari.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    private String name;
    private BigDecimal price;
    private String description;
    private String shortDescription;
    private String specification;
    private int quantity;
    private double cashbackPercent;
    private Long categoryId;
}
