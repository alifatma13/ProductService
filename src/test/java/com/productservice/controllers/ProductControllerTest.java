package com.productservice.controllers;

import com.productservice.ThirdPartyClient.fakestoreclient.FakeStoreClient;
import com.productservice.exceptions.ProductNotFoundException;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

    @Inject
    private ProductController productController;

    @Inject
    FakeStoreClient fakeStoreClient;

    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void testOnePlusOneIsTwoOrNot(){
        //assert (12 == 1+1);
        //assertEquals(1+1, 2, "1+1 should be 2");
        // if assert true test case succeeds
        assertTrue(111 == 2, "1+1 should be 2");
    }

        @Test
        void testGetProductByIdNegativeTC() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class, () -> productController.getProductByID(100000L));
        //assertNull(fakeStoreClient.getProductByID(1110000000L));
        }

}
