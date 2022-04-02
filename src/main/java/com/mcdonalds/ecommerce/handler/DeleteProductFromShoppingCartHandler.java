package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.service.DeleteProductFromShoppingCartService;
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
public class DeleteProductFromShoppingCartHandler {

    private final ResponseHelper responseHelper;
    private final DeleteProductFromShoppingCartService service;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        var shoppingCartRequestId = serverRequest.pathVariable("shoppingCartId");
        var shoppingCartId = Long.parseLong(shoppingCartRequestId);
        var productRequestId = serverRequest.pathVariable("productId");
        var productId = Long.parseLong(productRequestId);
        return service.execute(shoppingCartId, productId)
                //TODO: add DTO and MAPPER
                .flatMap(shoppingCart -> responseHelper.buildOK(Mono.just(shoppingCart)));
    }
}
