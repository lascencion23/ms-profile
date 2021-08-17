package com.spring.msprofile.repository;

import com.spring.msprofile.entity.TypeCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TypeCustomerRepository extends ReactiveMongoRepository<TypeCustomer, String> {
}
