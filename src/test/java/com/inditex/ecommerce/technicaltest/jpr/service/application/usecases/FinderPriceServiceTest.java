package com.inditex.ecommerce.technicaltest.jpr.service.application.usecases;

import com.inditex.ecommerce.technicaltest.jpr.service.domain.dtos.request.PriceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FinderPriceServiceTest {

    @Autowired
    private FinderPriceService finderPriceService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findPriceToApply() {
        //Given
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long idProduct = 35455L;
        Long idBrand = 1L;
        PriceRequest request = new PriceRequest();
        request.setApplicationDate(applyDate);
        request.setProductId(idProduct);
        request.setBrandId(idBrand);
        //When
        var result = finderPriceService.findPriceToApply(request);
        //Then
        assertTrue(result.isPresent());
    }
}