package com.jspiders.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.spring.entities.BillingDetails;

import com.jspiders.spring.repository.BillingDetailsRepository;

@RestController
@RequestMapping("/billing/method")
public class BillingDetailsController {
	@Autowired
	private BillingDetailsRepository repository;

	@GetMapping
	public Iterable<BillingDetails> readAll() {
		Iterable<BillingDetails> billingdetails = repository.findAll();
		return billingdetails;
	}
}
