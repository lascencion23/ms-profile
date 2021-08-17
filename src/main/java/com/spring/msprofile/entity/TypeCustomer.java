package com.spring.msprofile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@Data
@Builder
@Document("TypeCustomer")
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {
    @Id
    String id;

    @Valid
    EnumTypeCustomer value;

    SubType subType;

    enum EnumTypeCustomer {
        EMPRESARIAL, PERSONAL
    }
}
