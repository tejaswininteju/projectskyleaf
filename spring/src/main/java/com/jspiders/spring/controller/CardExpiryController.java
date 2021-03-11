package com.jspiders.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.spring.entities.CardExpiry;
import com.jspiders.spring.repository.CardExpiryRepository;

@RestController
@RequestMapping("/card/expiry")
public class CardExpiryController {
	@Autowired
	private CardExpiryRepository repository;

	@GetMapping
	public Iterable<CardExpiry> readAll() {
		Iterable<CardExpiry> cardexpiry = repository.findAll();
		return cardexpiry;
	}
}
