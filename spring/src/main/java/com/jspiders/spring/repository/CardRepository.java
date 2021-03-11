package com.jspiders.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspiders.spring.entities.Card;

public interface CardRepository extends CrudRepository<Card, String> {

}
