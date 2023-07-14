package com.bootexample4.products.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

public class ProductController_updateProduct_d88ecc4aa9_Test {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);
    }

    @Test
    public void testUpdateProduct_Success() {
        Product newProduct = new Product();
        newProduct.setName("Updated Product");
        newProduct.setDescription("Updated Description");
        newProduct.setPrice(200.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(1L, newProduct);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Updated Product", response.getBody().getName());
        assertEquals("Updated Description", response.getBody().getDescription());
        assertEquals(200.0, response.getBody().getPrice(), 0);
    }

    @Test
    public void testUpdateProduct_NotFound() {
        Product newProduct = new Product();
        newProduct.setName("Updated Product");
        newProduct.setDescription("Updated Description");
        newProduct.setPrice(200.0);

        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.updateProduct(1L, newProduct);

        assertEquals(404, response.getStatusCodeValue());
    }
}
