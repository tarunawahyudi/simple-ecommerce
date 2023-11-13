package com.tarunawahyudi.restful.service;

import com.tarunawahyudi.restful.entity.Product;
import com.tarunawahyudi.restful.model.CreateProductRequest;
import com.tarunawahyudi.restful.model.ProductResponse;
import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ValidationService validator;
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, ValidationService validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    public ProductResponse create(User user, CreateProductRequest request) {
        validator.validate(request);

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        productRepository.save(product);

        return convertToProductResponse(product);
    }

    public List<ProductResponse> show() {
        List<Product> products = productRepository.getAll();
        return products.stream()
                .map(this::convertToProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse get(int id) {
        Product product = productRepository.getById(id);
        return convertToProductResponse(product);
    }

    public ProductResponse update(CreateProductRequest request, int id) {
        validator.validate(request);

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        productRepository.update(product, id);

        return convertToProductResponse(product);
    }

    public void remove(int id) {
        productRepository.delete(id);
    }

    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
