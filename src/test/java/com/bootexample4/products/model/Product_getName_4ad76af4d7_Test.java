package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Product_getName_4ad76af4d7_Test {

    @InjectMocks
    private Product product;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        product.setName("TestProduct");
    }

    @Test
    public void testGetName_Success() {
        String expectedName = "TestProduct";
        String actualName = product.getName();
        assertEquals(expectedName, actualName, "The expected product name should match the actual product name");
    }

    @Test
    public void testGetName_Failure() {
        String expectedName = "WrongProduct";
        String actualName = product.getName();
        assertNotEquals(expectedName, actualName, "The expected product name should not match the actual product name");
    }
}
