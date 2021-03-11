package com.jspiders.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	private String holdername;

	private String cardtype;
	@Id
	private String cardbin;

	private String lastdigits;

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardbin() {
		return cardbin;
	}

	public void setCardbin(String cardbin) {
		this.cardbin = cardbin;
	}

	public String getLastdigits() {
		return lastdigits;
	}

	public void setLastDigits(String lastdigits) {
		this.lastdigits = lastdigits;
	}

	@Override
	public String toString() {
		return "Card [holdername=" + holdername + ", cardtype=" + cardtype + ", cardbin=" + cardbin + ", lastdigits="
				+ lastdigits + "]";
	}

}
