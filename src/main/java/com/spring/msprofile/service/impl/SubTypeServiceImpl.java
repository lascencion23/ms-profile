package com.spring.msprofile.service.impl;

import com.spring.msprofile.entity.SubType;
import com.spring.msprofile.repository.SubTypeRepository;
import com.spring.msprofile.service.SubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubTypeServiceImpl implements SubTypeService {

    @Autowired
    SubTypeRepository subTypeRepository;

    @Override
    public Mono<SubType> create(SubType subType) {
        return subTypeRepository.save(subType);
    }

    @Override
    public Flux<SubType> findAll() {
        return subTypeRepository.findAll();
    }

    @Override
    public Mono<SubType> findById(String id) {
        return subTypeRepository.findById(id);
    }

    @Override
    public Mono<SubType> update(SubType profile) {
        return subTypeRepository.save(profile);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return subTypeRepository.findById(id)
                .flatMap(
                        delete -> subTypeRepository.delete(delete)
                                .then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }
}
