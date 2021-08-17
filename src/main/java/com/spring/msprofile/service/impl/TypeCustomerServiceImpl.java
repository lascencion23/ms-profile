package com.spring.msprofile.service.impl;

import com.spring.msprofile.entity.SubType;
import com.spring.msprofile.entity.TypeCustomer;
import com.spring.msprofile.repository.TypeCustomerRepository;
import com.spring.msprofile.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {

    @Autowired
    TypeCustomerRepository typeCustomerRepository;

    @Autowired
    SubTypeServiceImpl subTypeServiceImpl;

    @Override
    public Mono<TypeCustomer> create(TypeCustomer typeCustomer) {
        return typeCustomerRepository.save(typeCustomer);
    }

    @Override
    public Flux<TypeCustomer> findAll() {
        return typeCustomerRepository.findAll();
    }

    @Override
    public Mono<TypeCustomer> findById(String id) {
        return typeCustomerRepository.findById(id);
    }

    @Override
    public Mono<TypeCustomer> update(TypeCustomer profile) {
        return typeCustomerRepository.save(profile);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return typeCustomerRepository.findById(id)
                .flatMap(
                        deleteTypeCustomer -> typeCustomerRepository.delete(deleteTypeCustomer)
                                .then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

    @Override
    public Mono<SubType> checkSubType(String id) {
        return subTypeServiceImpl.findById(id);
    }
}
