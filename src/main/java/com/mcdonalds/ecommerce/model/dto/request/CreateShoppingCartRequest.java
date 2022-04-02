package com.mcdonalds.ecommerce.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateShoppingCartRequest {
    private Long clientId;
    private Boolean isVip;

}
