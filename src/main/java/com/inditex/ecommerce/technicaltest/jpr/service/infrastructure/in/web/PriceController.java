package com.inditex.ecommerce.technicaltest.jpr.service.infrastructure.in.web;

import com.inditex.ecommerce.technicaltest.jpr.service.application.usecases.FinderPriceService;
import com.inditex.ecommerce.technicaltest.jpr.service.domain.dtos.request.PriceRequest;
import com.inditex.ecommerce.technicaltest.jpr.service.domain.dtos.response.PriceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/prices")
public class PriceController {

    private final FinderPriceService finderPriceService;

    @PostMapping("/price/apply")
    public ResponseEntity<PriceResponse> findApplyPrice(@RequestBody @Valid PriceRequest request) {
        var response = finderPriceService.findPriceToApply(request);
        if(response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }

}
