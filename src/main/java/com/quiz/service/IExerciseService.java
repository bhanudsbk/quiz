package com.quiz.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;
import com.quiz.dto.QuizResponse;

@Service
public interface IExerciseService {
	public  CompletableFuture<QuizResponse> getExercises(int amount, int category) throws InterruptedException, ExecutionException;
}
