package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductController_deleteProduct_8aa83376b7_Test {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteProduct_Success() {
        Product product = new Product();
        
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).delete(product);

        ResponseEntity<Object> responseEntity = productController.deleteProduct(1L);

        verify(productRepository, times(1)).delete(product);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testDeleteProduct_NotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Object> responseEntity = productController.deleteProduct(1L);

        verify(productRepository, times(0)).delete(any());
        assertEquals(404, responseEntity.getStatusCodeValue());
    }
}
