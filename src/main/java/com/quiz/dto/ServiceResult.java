package com.quiz.dto;

import java.util.List;

public class ServiceResult {

	public ServiceResult() {}

	public String type;
	public String difficulty;
	public String question;
	public List<String> allAnswers;
	public String correctAnswer;
	
	/**
	 * @param type
	 * @param difficulty
	 * @param question
	 * @param allAnswers
	 * @param correctAnswer
	 */
	public ServiceResult(String type, String difficulty, String question, List<String> allAnswers,
			String correctAnswer) {
		super();
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.allAnswers = allAnswers;
		this.correctAnswer = correctAnswer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAllAnswers() {
		return allAnswers;
	}
	public void setAllAnswers(List<String> allAnswers) {
		this.allAnswers = allAnswers;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


}
