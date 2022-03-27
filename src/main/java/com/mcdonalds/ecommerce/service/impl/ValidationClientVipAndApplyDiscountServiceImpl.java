package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import com.mcdonalds.ecommerce.service.ValidationClientVipAndDiscountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class ValidationClientVipAndApplyDiscountServiceImpl implements ValidationClientVipAndDiscountService {
    @Override
    public Mono<ShoppingCart> execute(ShoppingCart shoppingCart) {
        return null;
    }

    private Mono<ShoppingCart> validateClientVip(ShoppingCart shoppingCart) {
        return null;
    }

    private Mono<ShoppingCart> applyDiscount(ShoppingCart shoppingCart) {
        return null;
    }
}
