package com.quiz.exception;

public class QuizNotFoundException extends RuntimeException{

		private static final long serialVersionUID = 1L;

		public QuizNotFoundException(String amount, String category) {
	        super(String.format("Quiz was not found for amount %s and category %s",amount, category));
		}
	}
