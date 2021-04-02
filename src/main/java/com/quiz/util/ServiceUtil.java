package com.quiz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.dto.QuizDTO;
import com.quiz.dto.QuizResponse;
import com.quiz.dto.QuizResult;
import com.quiz.dto.ServiceResponse;
import com.quiz.dto.ServiceResult;
import com.quiz.service.IExerciseService;

@Service
public class ServiceUtil {

	final int _MUSIC = 11;
	final int _FILM = 12;
	private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);
	
	@Autowired
	private IExerciseService eService;
	
	public QuizDTO getFiveFilmAndMusicQuizes() throws InterruptedException, ExecutionException {
		try {
			logger.info("getFiveFilmAndMusicQuizes::Initiating the client call from service layer...");	
			CompletableFuture<QuizResponse> responseOne = eService.getExercises(5, 11);//get 5 film quiz
			CompletableFuture<QuizResponse> responseTwo = eService.getExercises(5, 12);//get 5 music quiz
			CompletableFuture<QuizResponse>[] allResponses = new CompletableFuture[] { responseOne, responseTwo };
		    // this will throw an exception if any of the futures complete exceptionally
		    QuizResponse[] combinedResult =  Arrays.stream(allResponses).map(CompletableFuture::join).toArray(QuizResponse[]::new);

	    return new QuizDTO(this.convertOutputDTO(combinedResult));
		}
		catch (Exception e) {
			logger.error("getFiveFilmAndMusicQuizes::Something went wrong; most likely: futures completed with exception or converting to DTO failed..", e.getMessage());
			return null;
		}
	}
	
	private List<ServiceResponse> convertOutputDTO(QuizResponse[] quizResponseArr) {
		List<ServiceResponse> serviceResponseList = new ArrayList<ServiceResponse>(); 
		List<QuizResponse> quizResponseList = Arrays.asList(quizResponseArr);//convert to list
		List<QuizResult> fullResults = quizResponseList.stream().flatMap(qr -> qr.getResults().stream()).collect(Collectors.toList());
		Map<String, List<QuizResult>> categoryGroups = fullResults.stream().collect(Collectors.groupingBy(QuizResult::getCategory)); 
		categoryGroups.forEach((k,v) -> {//loop through the grouped map to convert into result dto
			ServiceResponse serviceResponse = new ServiceResponse();
			serviceResponse.setCategory(k);
			List<ServiceResult> results = new ArrayList<ServiceResult>();
			serviceResponse.setCategory(k);
			v.forEach(r -> {
				ServiceResult sResult = new ServiceResult(r.Type, r.Difficulty, r.Question, r.incorrectAnswers, r.correctAnswer);
				sResult.allAnswers.add(sResult.correctAnswer);
				results.add(sResult);
			});
			serviceResponse.setResults(results);
			serviceResponseList.add(serviceResponse);
		});
		
		return serviceResponseList;
	}
}
