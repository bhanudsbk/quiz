package com.quiz.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.quiz.client.QuizServiceClient;
import com.quiz.dto.QuizResponse;

@Service
public class ExerciseServiceImpl implements IExerciseService{
	private static final Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);
	@Autowired
	QuizServiceClient quizServiceClient;
	
	@Override
	@Async("taskExecutor")
	public  CompletableFuture<QuizResponse> getExercises(int amount, int category) throws InterruptedException, ExecutionException {
		try {
			logger.info(String.format("getExercises::Calling Quiz Client with:amount: %s,category: %s Thread: %s",amount,category, Thread.currentThread().getName()));
			QuizResponse response = quizServiceClient.getQuizExercise(amount, category);
			
			return CompletableFuture.completedFuture(response);
		}
		catch (Exception e) {
			logger.error(String.format("getExercises::amount: %s,category: %s",amount, category),e.getMessage());
			return null;
		}
	}
}
