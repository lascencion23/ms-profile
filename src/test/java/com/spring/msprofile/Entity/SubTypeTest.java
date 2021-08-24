package com.spring.msprofile.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.spring.msprofile.entity.SubType;
import com.spring.msprofile.entity.SubType.EnumSubType;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class SubTypeTest {

	@Autowired
	private ReactiveMongoTemplate template;
	
	@Test
	public void persist() throws Exception {
		SubType st = new SubType("0", EnumSubType.NORMAL);
		Mono<SubType> save = this.template.save(st);
		StepVerifier
			.create(save)
			.expectNextMatches(match -> match.getId() != null && match.getValue().equals(EnumSubType.NORMAL))
			.verifyComplete();
	}
	
}
