package com.example.TikintiMateriallari.services;

import com.example.TikintiMateriallari.dtos.product.*;
import com.example.TikintiMateriallari.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    boolean createProduct(ProductCreateDto productCreate);
    boolean updateProduct(Long id, ProductUpdateDto productUpdate);
    List<ProductDashboardDto> getDashboardProducts();

    ProductUpdateDto getUpdatedProduct(Long id);

    List<ProductDashboardDto> getDashboardproducts();

    List<ProductPinnedDto> getPinnedProducts();

    ProductDetailDto getProductBySlug(String slug);

    ProductFilterDto filterProducts(BigDecimal minPrice, BigDecimal maxPrice, String sort, String order, String categorySlug);

    Product getProductById(Long productId);
}
