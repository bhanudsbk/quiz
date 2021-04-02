package com.quiz.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.config.SpringFeignConfiguration;
import com.quiz.dto.QuizResponse;

@FeignClient(name="quizapi", url= "${quiz.service.baseurl}", configuration = SpringFeignConfiguration.class)
public interface QuizServiceClient {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public QuizResponse getQuizExercise(@RequestParam("amount") int amount, @RequestParam("category") int category);
}
