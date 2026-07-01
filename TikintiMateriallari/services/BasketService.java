package com.example.TikintiMateriallari.services;

import com.example.TikintiMateriallari.dtos.basket.BasketAddDto;
import com.example.TikintiMateriallari.dtos.basket.BasketUserDto;

import java.util.List;

public interface BasketService {
    List<BasketUserDto> getBasketItems(String email);

    void createBasketItem(BasketAddDto basketAddDto, String email);
}
