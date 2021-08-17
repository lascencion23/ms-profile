package com.spring.msprofile.service;

import com.spring.msprofile.entity.SubType;
import com.spring.msprofile.entity.TypeCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeCustomerService {
    public Mono<TypeCustomer> create(TypeCustomer profile);

    public Flux<TypeCustomer> findAll();

    public Mono<TypeCustomer> findById(String id);

    public Mono<TypeCustomer> update(TypeCustomer profile);

    public Mono<Boolean> delete(String id);

    public Mono<SubType> checkSubType(String id);
}
