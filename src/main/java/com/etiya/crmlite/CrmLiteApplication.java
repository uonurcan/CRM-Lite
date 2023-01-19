package com.etiya.crmlite;

import com.etiya.crmlite.core.utilities.exceptions.BusinessException;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;

import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
@SpringBootApplication
@Configuration
public class CrmLiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrmLiteApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception)
	{
		//Validation exception handle edildi.
		//TODA:ErrorDataResult olarak hataları döndür.
		Map<String,String> errors=new HashMap<>();
		//ErrorDataResult<String> hata=new ErrorDataResult<String>();
		for(FieldError fieldError : exception.getBindingResult().getFieldErrors())
		{
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<>(errors,"Not valid exception") ;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException)
	{
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(), "BUSINESS.EXCEPTION");
		return errorDataResult;
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
}
