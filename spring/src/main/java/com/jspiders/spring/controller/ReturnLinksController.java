package com.jspiders.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.spring.entities.ReturnLinks;
import com.jspiders.spring.repository.ReturnLinksRepository;

@RestController
@RequestMapping("/return/links")
public class ReturnLinksController {
	@Autowired
	private ReturnLinksRepository repository;

	@GetMapping
	public Iterable<ReturnLinks> readAll() {
		Iterable<ReturnLinks> returnlinks = repository.findAll();
		return returnlinks;
	}

}
