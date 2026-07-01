package com.example.TikintiMateriallari.repositories;

import com.example.TikintiMateriallari.dtos.product.ProductPinnedDto;
import com.example.TikintiMateriallari.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long > {

    @Query(nativeQuery = true, value = "SELECT * FROM product_pinned_list")
    List<ProductPinnedDto> getPinnedProducts();

    Product findBySlug(String slug);

}
