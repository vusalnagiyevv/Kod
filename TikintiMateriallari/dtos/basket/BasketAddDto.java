package com.example.TikintiMateriallari.dtos.basket;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketAddDto {
    private Long productId;
    private int quantity;
}
