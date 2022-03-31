package com.mcdonalds.ecommerce.service;

import reactor.core.publisher.Mono;

public interface DeleteProductFromShoppingCartService {
    Mono<Boolean> execute(Long id, Long productId);
}
