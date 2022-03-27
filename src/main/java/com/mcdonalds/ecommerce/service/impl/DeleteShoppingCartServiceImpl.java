package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.service.DeleteShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Log4j2
@Service
public class DeleteShoppingCartServiceImpl implements DeleteShoppingCartService {
    @Override
    public Mono<Boolean> execute(Long id) {
        return null;
    }
}
