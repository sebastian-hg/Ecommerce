package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.service.DeleteShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Component
@Log4j2
public class DeleteShoppingCartHandler {

    private final ResponseHelper responseHelper;
    private final DeleteShoppingCartService service;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        var requestId = serverRequest.pathVariable("id");
        var deleteId = Long.parseLong(requestId);

        return service.execute(deleteId)
                .flatMap(aBoolean -> responseHelper.buildOK());
    }
}
