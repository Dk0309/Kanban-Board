package com.project.LayOutService.domain;

import org.springframework.data.annotation.Id;

public class Card {

	@Id
	private String cardId;
	private String cardName;
	private String assign;
	private String status;
	private String deadline;
	private String summary;
	private String priority;
	
	public Card() {
		super();	
	}

	public Card(String cardId, String cardName, String assign, String status, String deadline, String summary,
			String priority) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.assign = assign;
		this.status = status;
		this.deadline = deadline;
		this.summary = summary;
		this.priority = priority;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", assign=" + assign + ", status=" + status
				+ ", deadline=" + deadline + ", summary=" + summary + ", priority=" + priority + "]";
	}
	
	
	
	
}
