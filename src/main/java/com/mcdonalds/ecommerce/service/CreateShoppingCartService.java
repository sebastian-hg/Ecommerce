package com.mcdonalds.ecommerce.service;

import com.mcdonalds.ecommerce.model.Client;
import com.mcdonalds.ecommerce.model.ShoppingCart;
import reactor.core.publisher.Mono;

public interface CreateShoppingCartService {
    Mono<ShoppingCart>execute(Client client);
}
