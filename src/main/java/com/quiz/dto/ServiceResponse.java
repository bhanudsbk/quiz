package com.quiz.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"category", "results" })
public class ServiceResponse {

	public ServiceResponse() {}
	/**
	 * @param category
	 * @param results
	 */
	public ServiceResponse(String category, List<ServiceResult> results) {
		super();
		Category = category;
		Results = results;
	}

	@JsonProperty("category")
	public String Category;
	
	@JsonProperty("results")
	public List<ServiceResult> Results;

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public List<ServiceResult> getResults() {
		return Results;
	}

	public void setResults(List<ServiceResult> results) {
		Results = results;
	}
}
