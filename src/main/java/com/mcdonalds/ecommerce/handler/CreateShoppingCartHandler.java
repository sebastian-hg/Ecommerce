package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.mapper.CreateShoppingCartMapper;
import com.mcdonalds.ecommerce.model.dto.request.CreateShoppingCartRequest;
import com.mcdonalds.ecommerce.service.CreateShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
@Log4j2
public class CreateShoppingCartHandler {

    private final ResponseHelper responseHelper;
    private final CreateShoppingCartService service;
    private final CreateShoppingCartMapper mapper;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);

        return serverRequest.bodyToMono(CreateShoppingCartRequest.class)
                .flatMap(service::execute)
                .map(mapper::toResponseDto)
                .doOnNext(createShoppingCartResponse -> log.info("response, {}",createShoppingCartResponse))
                .flatMap(createShoppingCartResponse -> {
                    return responseHelper.buildOK(Mono.just(createShoppingCartResponse));
                });
    }
}


