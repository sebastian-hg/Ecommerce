package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.mapper.ShoppingCartMapper;
import com.mcdonalds.ecommerce.model.dto.request.AddProductRequest;
import com.mcdonalds.ecommerce.service.AddProductToShoppingCartService;
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
public class AddProductToShoppingCartHandler {

    private final ResponseHelper responseHelper;
    private final AddProductToShoppingCartService service;
    private final ShoppingCartMapper mapper;
    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);

        var requestId = serverRequest.pathVariable("id");
        var id = Long.parseLong(requestId);
        return serverRequest.bodyToMono(AddProductRequest.class)
                //TODO: add validation for close shopping cart
                .flatMap(addProductRequest -> service.execute(id, addProductRequest))
                .flatMap(mapper::execute)
                .flatMap(response -> responseHelper.buildOK(Mono.just((response))));
    }
}
