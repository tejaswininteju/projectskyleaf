package com.jspiders.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.spring.entities.Card;

import com.jspiders.spring.repository.CardRepository;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired
	private CardRepository repository;

	@GetMapping
	public Iterable<Card> readAll() {
		Iterable<Card> card = repository.findAll();
		return card;
	}
}
