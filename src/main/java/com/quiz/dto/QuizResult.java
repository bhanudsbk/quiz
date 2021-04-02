package com.quiz.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizResult {
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public QuizResult() {}


	/**
	 * @param category
	 * @param type
	 * @param difficulty
	 * @param question
	 * @param correctAnswer
	 * @param incorrectAnswers
	 */
	public QuizResult(String category, String type, String difficulty, String question, String correctAnswer,
			List<String> incorrectAnswers) {
		super();
		Category = category;
		Type = type;
		Difficulty = difficulty;
		Question = question;
		this.correctAnswer = correctAnswer;
		this.incorrectAnswers = incorrectAnswers;
	}

	@JsonProperty("category")
	public String Category;
	
	@JsonProperty("type")
	public String Type;
	
	@JsonProperty("difficulty")
	public String Difficulty;
	
	@JsonProperty("question")
	public String Question;
	
	@JsonProperty("correct_answer")
	public String correctAnswer;
	
	@JsonProperty("incorrect_answers")
	public List<String> incorrectAnswers;


	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(List<String> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDifficulty() {
		return Difficulty;
	}

	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

}
