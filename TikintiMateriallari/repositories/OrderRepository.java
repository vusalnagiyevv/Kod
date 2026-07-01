package com.example.TikintiMateriallari.repositories;

import com.example.TikintiMateriallari.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
