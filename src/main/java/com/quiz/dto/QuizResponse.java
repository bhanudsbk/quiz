package com.quiz.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizResponse {

	public QuizResponse () {}
	
	
	/**
	 * @param responseCode
	 * @param results
	 */
	public QuizResponse(String responseCode, List<QuizResult> results) {
		super();
		this.responseCode = responseCode;
		this.results = results;
	}
	
	@JsonProperty("response_code")
	public String responseCode;

	@JsonProperty("results")
	public List<QuizResult> results;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<QuizResult> getResults() {
		return results;
	}

	public void setResults(List<QuizResult> results) {
		this.results = results;
	}
}
