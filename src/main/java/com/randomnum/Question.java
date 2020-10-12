package com.randomnum;

public class Question {
	private final String responses;
	private final String question;

	public Question(String responses, String question) {
		this.responses = responses;
		this.question = question;
	}

	public String getResponses() {
		return responses;
	}

	public String getQuestion() {
		return question;
	}
}
