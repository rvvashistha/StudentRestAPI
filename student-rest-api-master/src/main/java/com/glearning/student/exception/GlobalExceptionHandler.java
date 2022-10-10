package com.glearning.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handlInvalidStudentId(IllegalArgumentException exception) {
		System.out.println("Invalid student id passed :: "+exception.getMessage());
		//Error error = new Error(100, exception.getMessage());
		//Person person = new Person(12, 22, true, true, false, "Praveen", "Mohan");
		/*
		 * Person person = Person
		 * 						.builder()
		 * 						.id(22)
		 * 						.age(22)
		 * 						.isMarried(true)
		 * 						.fName("Praveen")
		 * 						.lastName("Mohan")
		 * 					.build();
		 */
		Error error = Error
						.builder()
						.code(100)
						.message(exception.getMessage())
						.build();
		return error;
	}
	

}

@Builder
@AllArgsConstructor
@Getter
class Error{
	private int code;
	private String message;
}
