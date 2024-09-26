package com.bootexample4.products.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductController_getAllProducts_ce6c2f6265_Test {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    Product product1;
    Product product2;

    @Before
    public void setUp() {
        product1 = new Product();
        product1.setId(1L);
        product1.setName("Product1");
        product1.setDescription("Description1");

        product2 = new Product();
        product2.setId(2L);
        product2.setName("Product2");
        product2.setDescription("Description2");
    }

    @Test
    public void testGetAllProducts() {
        List<Product> expectedProducts = Arrays.asList(product1, product2);
        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<Product> actualProducts = productController.getAllProducts();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testGetAllProducts_Empty() {
        when(productRepository.findAll()).thenReturn(Arrays.asList());

        List<Product> actualProducts = productController.getAllProducts();

        assertEquals(0, actualProducts.size());
    }
}
