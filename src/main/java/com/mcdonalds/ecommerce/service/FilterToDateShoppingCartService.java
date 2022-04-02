package com.mcdonalds.ecommerce.service;

import com.mcdonalds.ecommerce.model.ShoppingCart;
import reactor.core.publisher.Mono;

public interface FilterToDateShoppingCartService {
    Mono<ShoppingCart> execute(Integer documentId);
}
