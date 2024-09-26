package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class Product_setId_e7f341730a_Test {

    @InjectMocks
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testSetId_validId() {
        Long expectedId = 100L;
        product.setId(expectedId);
        assertEquals(expectedId, product.getId(), "The ID set in the product does not match the expected ID.");
    }

    @Test
    public void testSetId_nullId() {
        product.setId(null);
        assertNull(product.getId(), "The ID of the product should be null.");
    }
}
