package com.mcdonalds.ecommerce.model.dto.request;

import lombok.Data;

@Data
public class AddProductRequest {
    private Long productId;
    private Integer numberOfProduct;
}
