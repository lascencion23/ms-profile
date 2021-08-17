package com.spring.msprofile.service;

import com.spring.msprofile.entity.SubType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubTypeService {
    public Mono<SubType> create(SubType profile);

    public Flux<SubType> findAll();

    public Mono<SubType> findById(String id);

    public Mono<SubType> update(SubType profile);

    public Mono<Boolean> delete(String id);
}
