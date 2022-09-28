package com.mcdonalds.ecommerce.service.impl;

import com.mcdonalds.ecommerce.exception.ClientExistException;
import com.mcdonalds.ecommerce.mapper.AddClientMapper;
import com.mcdonalds.ecommerce.model.Client;
import com.mcdonalds.ecommerce.model.dto.request.AddClientRequest;
import com.mcdonalds.ecommerce.repository.ClientRepository;
import com.mcdonalds.ecommerce.service.AddClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddClientServiceImpl implements AddClientService {

    private final ClientRepository repository;
    private final AddClientMapper mapper;


    @Override
    public Mono<Client> execute(AddClientRequest addClientRequest) {
        /*return Mono.just(addClientRequest)
                .zipWith(Mono.just(repository.existByDocumentNational(addClientRequest.getDocumentID())))
                .map(Tuple2::getT2)
                .filter(Boolean.TRUE::equals)
                .switchIfEmpty(Mono.error(ClientExistException::new))
                .map(Tuple2::getT1) // al llegar aqui el tuple no devuelve el valor del t1 asignado, si no que devuelve objets
                .map(repository::save);*/

        return Mono.just(repository.existByDocumentNational(addClientRequest.getDocumentID()))
                .filter(Boolean.TRUE::equals)
                .switchIfEmpty(Mono.error(ClientExistException::new))
                .map(aBoolean -> {
                    var client = mapper.toClient(addClientRequest);
                    return repository.save(client);
                });
    }
}
