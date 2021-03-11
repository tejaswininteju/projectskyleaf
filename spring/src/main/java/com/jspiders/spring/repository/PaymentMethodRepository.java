package com.jspiders.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.spring.entities.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, String> {

}
