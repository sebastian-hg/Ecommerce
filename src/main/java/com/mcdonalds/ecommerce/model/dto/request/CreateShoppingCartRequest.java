package com.mcdonalds.ecommerce.model.dto.request;

import lombok.Data;

@Data
public class CreateShoppingCartRequest {
    private Long clientId;
    private Boolean isVip;

}
