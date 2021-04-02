package com.quiz.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.dto.QuizDTO;
import com.quiz.exception.QuizNotFoundException;
import com.quiz.util.ServiceUtil;

@RestController
@RequestMapping("/exercise")
public class QuizController {

	private static final Logger logger = LoggerFactory.getLogger(QuizController.class);
	@Autowired
	private ServiceUtil eService;
	
	@Autowired
	ObjectMapper oMapper;
	
	@GetMapping("/quiz")
	public QuizDTO getExercises() throws JsonProcessingException{
		try {
			Optional<QuizDTO> exercises = Optional.ofNullable(eService.getFiveFilmAndMusicQuizes());
			if(!exercises.isPresent()) {
				throw new QuizNotFoundException("5", "11 & 12");
			}
			return exercises.get();
			
		} catch (Exception e) {
			logger.error("getExercises::exception occured, check logs", e.getMessage());
			return null;
		} 
	}
}
