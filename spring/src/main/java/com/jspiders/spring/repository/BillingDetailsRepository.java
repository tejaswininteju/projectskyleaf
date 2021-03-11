package com.jspiders.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.spring.entities.BillingDetails;

public interface BillingDetailsRepository extends CrudRepository<BillingDetails, String> {

}
