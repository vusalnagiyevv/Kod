package com.example.TikintiMateriallari.services.impls;

import com.example.TikintiMateriallari.dtos.category.CategoryPinnedDto;
import com.example.TikintiMateriallari.dtos.product.*;
import com.example.TikintiMateriallari.helpers.SeoHelper;
import com.example.TikintiMateriallari.models.Category;
import com.example.TikintiMateriallari.models.Photo;
import com.example.TikintiMateriallari.models.Product;
import com.example.TikintiMateriallari.repositories.ProductRepository;
import com.example.TikintiMateriallari.services.CategoryService;
import com.example.TikintiMateriallari.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @Override
    public boolean createProduct(ProductCreateDto productCreate) {
        Category category = categoryService.getCategoryById(productCreate.getCategoryId());
        String slug = SeoHelper.createSeoUrl((productCreate.getName()));
        Product product = new Product();
        product.setName(productCreate.getName());
        product.setPrice(productCreate.getPrice());
        product.setCategory(category);
        product.setSlug(slug);
        product.setDescription(productCreate.getDescription());
        product.setQuantity(productCreate.getQuantity());
        product.setShortDescription(productCreate.getShortDescription());
        product.setCashbackPercent(productCreate.getCashbackPercent());
        product.setSpecification(productCreate.getSpecification());
        productRepository.save(product);

        return true;
    }

    @Override
    public boolean updateProduct(Long id, ProductUpdateDto productUpdate) {

        Category category = categoryService.getCategoryById(productUpdate.getCategoryId());
        String slug = SeoHelper.createSeoUrl((productUpdate.getName()));
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setCategory(category);
        product.setSlug(slug);
        product.setDescription(productUpdate.getDescription());
        product.setQuantity(productUpdate.getQuantity());
        product.setShortDescription(productUpdate.getShortDescription());
        product.setCashbackPercent(productUpdate.getCashbackPercent());
        product.setSpecification(productUpdate.getSpecification());
        productRepository.save(product);


        return true;

    }

    @Override
    public List<ProductDashboardDto> getDashboardProducts() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            return List.of();
        }
        List<ProductDashboardDto> productDashboardDtoList = productList.stream().map(product -> modelMapper.map(product, ProductDashboardDto.class)).toList();
        return productDashboardDtoList;

    }

    @Override
    public ProductUpdateDto getUpdatedProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductUpdateDto productUpdateDto = modelMapper.map(product, ProductUpdateDto.class);
        return productUpdateDto;
    }

    @Override
    public List<ProductDashboardDto> getDashboardproducts() {
        return List.of();
    }

    @Override
    public List<ProductPinnedDto> getPinnedProducts() {
        List<ProductPinnedDto> productPinnedDtoList = productRepository.getPinnedProducts();



        return productPinnedDtoList;
    }

    @Override
    public ProductDetailDto getProductBySlug(String slug) {
        Product product = productRepository.findBySlug(slug);
        if (product != null) {
            return modelMapper.map(product, ProductDetailDto.class);
        }
        return new ProductDetailDto();
    }

    @Override
    public ProductFilterDto filterProducts(BigDecimal minPrice, BigDecimal maxPrice, String sort, String order, String categorySlug) {

        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
