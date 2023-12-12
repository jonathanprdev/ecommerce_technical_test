package com.inditex.ecommerce.technicaltest.jpr.service.domain.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PriceRequest {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
