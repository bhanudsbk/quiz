package com.quiz.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class SpringFeignConfiguration {

	@Bean
	public Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
		return new SpringFormEncoder(new SpringEncoder(converters));
	}
}
