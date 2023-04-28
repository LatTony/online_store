package com.internet_store.test.service;

import com.internet_store.test.dto.ProductDto;
import com.internet_store.test.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.internet_store.test.entity.Product;
import com.internet_store.test.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.fromDto(productDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        return productMapper.toDto(product);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}


