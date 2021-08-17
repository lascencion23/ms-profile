package com.spring.msprofile.controller;

import com.spring.msprofile.entity.SubType;
import com.spring.msprofile.service.SubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RefreshScope
@RestController
@RequestMapping("/subtype")
public class SubTypeController {

    @Autowired
    SubTypeService subTypeService;

    @GetMapping("/list")
    public Flux<SubType> list(){
        return subTypeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<SubType> findById(@PathVariable String id){
        return subTypeService.findById(id);
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<SubType>> create(@RequestBody SubType subType){
        return subTypeService.create(subType)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer , HttpStatus.CREATED))
                .onErrorResume(t->Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<SubType>> update(@Valid @RequestBody SubType subType) {
        return subTypeService.update(subType)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable String id) {
        return subTypeService.delete(id)
                .filter(st -> st)
                .map(deleteCustomer -> new ResponseEntity<>("Customer Deleted", HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
