package com.example.TikintiMateriallari.repositories;

import com.example.TikintiMateriallari.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long > {
    Basket findByProductId(Long productId);

    Basket findByProductIdAndUserId(Long productId, Long id);
}
