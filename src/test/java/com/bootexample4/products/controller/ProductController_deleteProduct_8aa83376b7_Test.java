package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductController_deleteProduct_8aa83376b7_Test {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testDeleteProductSuccess() {
        Product product = new Product();
        product.setId(1L);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        ResponseEntity<Object> response = productController.deleteProduct(1L);

        assertEquals(200, response.getStatusCodeValue());
        Mockito.verify(productRepository, Mockito.times(1)).delete(product);
    }

    @Test
    public void testDeleteProductNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Object> response = productController.deleteProduct(1L);

        assertEquals(404, response.getStatusCodeValue());
        Mockito.verify(productRepository, Mockito.times(0)).delete(anyLong());
    }
}
