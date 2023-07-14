package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class Product_getName_4ad76af4d7_Test {

    @Mock
    private Product product;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNameSuccess() {
        String expectedName = "Test Product";
        when(product.getName()).thenReturn(expectedName);

        String actualName = product.getName();

        assertEquals(expectedName, actualName, "The name returned by the getName method does not match the expected name");
    }

    @Test
    public void testGetNameFailure() {
        String unexpectedName = "Unexpected Product";
        when(product.getName()).thenReturn("Test Product");

        String actualName = product.getName();

        assertNotEquals(unexpectedName, actualName, "The name returned by the getName method matches the unexpected name");
    }
}
