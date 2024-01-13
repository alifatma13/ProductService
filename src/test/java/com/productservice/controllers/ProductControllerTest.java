package com.productservice.controllers;

import com.productservice.ThirdPartyClient.fakestoreclient.FakeStoreClient;
import com.productservice.dtos.GenericProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Inject
    private ProductController productController;

    @Inject
    FakeStoreClient fakeStoreClient;

    @MockBean
    private ProductService productService;

    @Captor
    private ArgumentCaptor<Long> argumentCaptor;
    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void testOnePlusOneIsTwoOrNot(){
        //assert (12 == 1+1);
        //assertEquals(1+1, 2, "1+1 should be 2");
        // if assert true test case succeeds
        assertTrue(1+1 == 2, "1+1 should be 2");
    }

    /*    @Test
        void testGetProductByIdNegativeTC() throws ProductNotFoundException {
        assertThrows(ProductNotFoundException.class, () -> productController.getProductByID(1008000L));
        //assertNull(fakeStoreClient.getProductByID(1110000000L));
        }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        when(productService.getProductByID(any(Long.class))).thenReturn(genericProductDto);
        //when(productService.getProductByID(any(Long.class))).thenReturn(null);

        GenericProductDto genericProductDto1 = productController.getProductByID(875897L);

        //assertNull(productController.getProductByID(100L));
        assertEquals(genericProductDto, genericProductDto1);
    }


    @Test
    void testGetProductByIdMockingException() throws ProductNotFoundException {
        when(productService.getProductByID(1L))
                .thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class,
                () -> productController.getProductByID(1L));
    }

    @Test
    void testGetProductByIdForCustomLogic() throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();

        when(productService.getProductByID(10L))
                .thenReturn(genericProductDto);


        GenericProductDto genericProductDto1 =  productController.getProductByID(10L);
        assertEquals(genericProductDto, genericProductDto1);
    }


    @Test
    @DisplayName("testProductControllerCallsProductServiceWithSameProductIdAsInput")
    void testIfSameInput() throws ProductNotFoundException {
        //This is the test case to check if productController is passing the same productId to the
        //productService as the input.
        Long id = 100L;

        when(productService.getProductByID(id)).thenReturn(new GenericProductDto());

        GenericProductDto genericProductDto =  productController.getProductByID(id);

        verify(productService).getProductByID(argumentCaptor.capture());

        assertEquals(id, argumentCaptor.getValue());
    }

*/
}
