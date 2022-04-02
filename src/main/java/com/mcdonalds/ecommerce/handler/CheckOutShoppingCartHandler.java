package com.mcdonalds.ecommerce.handler;

import com.mcdonalds.ecommerce.helper.ResponseHelper;
import com.mcdonalds.ecommerce.mapper.ShoppingCartMapper;
import com.mcdonalds.ecommerce.repository.ShoppingCartRepository;
import com.mcdonalds.ecommerce.service.ValidationFourProductAndApply4X3DiscountService;
import com.mcdonalds.ecommerce.service.ValidationShoppingCartVipAndApplyDiscountService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
@Log4j2
@Service
public class CheckOutShoppingCartHandler {

    private final ResponseHelper responseHelper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ValidationShoppingCartVipAndApplyDiscountService validationShoppingCartVipAndApplyDiscountService;
    private final ValidationFourProductAndApply4X3DiscountService validationFourProductAndApply4X3DiscountService;
    private final ShoppingCartMapper mapper;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        var idRequest = serverRequest.pathVariable("id");
        var idShoppingCart = Long.parseLong(idRequest);
        return Mono.just(idShoppingCart)
                .flatMap(validationShoppingCartVipAndApplyDiscountService::execute)
                .flatMap(shoppingCart ->
                        validationFourProductAndApply4X3DiscountService.execute(shoppingCart.getId())
                )
                .map(shoppingCartRepository::save)
                .flatMap(mapper::execute)
                .flatMap(response -> {
                    return responseHelper.buildOK(Mono.just(response));
                });
    }

}

