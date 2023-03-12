package com.etsCaffe.productServices.service;

import com.etsCaffe.productServices.dto.ProductRequest;
import com.etsCaffe.productServices.dto.ProductResponse;
import com.etsCaffe.productServices.model.Product;
import com.etsCaffe.productServices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .menuName(productRequest.getMenuName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .menuName(product.getMenuName())
                .description(product.getDescription())
                .Qty(product.getQty())
                .price(product.getPrice())
                .build();
    }
}
