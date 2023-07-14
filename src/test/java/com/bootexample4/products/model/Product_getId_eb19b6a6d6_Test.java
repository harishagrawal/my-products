package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Product_getId_eb19b6a6d6_Test {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testGetIdSuccess() {
        Long expectedId = 1L;
        // Assuming there's a method setId in Product class
        product.setId(expectedId);
        Long actualId = product.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetIdNull() {
        // Assuming there's a method setId in Product class
        product.setId(null);
        Long actualId = product.getId();
        assertNull(actualId);
    }
}
