package com.jspiders.spring.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jspiders.spring.entities.BillingDetails;
import com.jspiders.spring.entities.Card;
import com.jspiders.spring.entities.CardExpiry;
import com.jspiders.spring.entities.PaymentMethod;
import com.jspiders.spring.entities.ReturnLinks;
import com.jspiders.spring.repository.BillingDetailsRepository;
import com.jspiders.spring.repository.CardExpiryRepository;
import com.jspiders.spring.repository.CardRepository;
import com.jspiders.spring.repository.PaymentMethodRepository;
import com.jspiders.spring.repository.ReturnLinksRepository;

//import com.jspiders.spring.entities.PaymentMethod;
//import com.jspiders.spring.repository.PaymentMethodRepository;

@RestController
@RequestMapping("/payment/method")
public class MyFirstController {

	@Autowired
	private PaymentMethodRepository repository;

	@Autowired
	private BillingDetailsRepository billingRepository;

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardExpiryRepository cardExpiryRepository;

	@Autowired
	private ReturnLinksRepository returnlinksRepository;

	@GetMapping("/readAll")
	public String readAll() {
		Iterable<PaymentMethod> all = repository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(all);

		JSONArray j1 = new JSONArray(json);
		JSONObject res = new JSONObject(j1.get(0).toString());

		Iterable<BillingDetails> billingResponse = billingRepository.findAll();

		json = gson.toJson(billingResponse);
		JSONObject billingJson = new JSONObject(new JSONArray(json).get(0).toString());

		res.put("BillingDetails", billingJson);

		// to get card

		Iterable<Card> cardResponse = cardRepository.findAll();

		json = gson.toJson(cardResponse);
		JSONObject cardJson = new JSONObject(new JSONArray(json).get(0).toString());
		// GET the card expiry
		Iterable<CardExpiry> cardExpiry = cardExpiryRepository.findAll();

		json = gson.toJson(cardExpiry);
		JSONObject cardExpiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("caredExpiry", cardExpiryJson);
		res.put("card", cardJson);

		Iterable<ReturnLinks> returnlink = returnlinksRepository.findAll();

		json = gson.toJson(returnlink);
		JSONObject returnlinksJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("returnLink", returnlinksJson);

		res.put("returnlinks", returnlinksJson);
		return res.toString();

	}

	@PostMapping("/create")
	public PaymentMethod create(@RequestBody PaymentMethod payment) {
		return repository.save(payment);
	}

	/*
	 * @PutMapping("/update") public PaymentMethod update(@RequestBody PaymentMethod
	 * payment) { return repository.save(payment); }
	 * 
	 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable String id) {
	 * repository.deleteById(id); }
	 */
}
