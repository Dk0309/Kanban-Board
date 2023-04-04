package com.project.LayOutService.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Pillar {
	
	@Id
	private String pillarName;
	private List<Card> cards;
	
	public Pillar() {
		super();	
	}

	public Pillar(String pillarName, List<Card> cards) {
		super();
		this.pillarName = pillarName;
		this.cards = cards;
	}

	public String getPillarName() {
		return pillarName;
	}

	public void setPillarName(String pillarName) {
		this.pillarName = pillarName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Pillar [pillarName=" + pillarName + ", card=" + cards + "]";
	}
	
	

}
