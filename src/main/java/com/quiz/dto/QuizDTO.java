package com.quiz.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizDTO {

	public QuizDTO() {}

	/**
	 * @param quiz
	 */
	public QuizDTO(List<ServiceResponse> quiz) {
		super();
		this.quiz = quiz;
	}

	@JsonProperty("quiz")
	public List<ServiceResponse> quiz;

	public List<ServiceResponse> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<ServiceResponse> quiz) {
		this.quiz = quiz;
	}
}
