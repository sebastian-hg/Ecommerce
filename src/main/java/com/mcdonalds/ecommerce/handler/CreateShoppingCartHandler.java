package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
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

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        return responseHelper.buildOK();
    }
}
