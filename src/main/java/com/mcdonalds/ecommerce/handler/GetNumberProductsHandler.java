package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.mapper.GetNumberProductsMapper;
import com.mcdonalds.ecommerce.service.GetStatusFromShoppingCartService;
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
public class GetNumberProductsHandler {
    private final GetNumberProductsMapper getNumberProductsMapper;
    private final GetStatusFromShoppingCartService service;
    private final ResponseHelper responseHelper;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        var personId = (serverRequest.queryParam("id").get());
        var id = Long.parseLong(personId);

        return service.execute(id)
                .flatMap(shoppingCart ->
                {
                    return responseHelper.buildOK(Mono.just(getNumberProductsMapper.toResponseDto(shoppingCart)));
                });
    }
}
