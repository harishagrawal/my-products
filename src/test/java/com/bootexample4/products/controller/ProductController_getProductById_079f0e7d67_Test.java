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

public class ProductController_getProductById_079f0e7d67_Test {

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
    }

    @Test
    public void testGetProductById_Success() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = controller.getProductById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testGetProductById_NotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = controller.getProductById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }
}
