package com.spring.msprofile.repository;

import com.spring.msprofile.entity.SubType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SubTypeRepository extends ReactiveMongoRepository<SubType, String> {
}
