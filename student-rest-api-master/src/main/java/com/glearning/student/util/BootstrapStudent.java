package com.glearning.student.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.glearning.student.model.Student;
import com.glearning.student.repository.StudentRepository;

@Component
public class BootstrapStudent {
	
	private final StudentRepository studentRepository;
	private final Faker faker = new Faker();
	
	public BootstrapStudent(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady(ApplicationReadyEvent event) {
	
		for(int i = 0; i< 100; i++) {
			String name = faker.name().firstName();
			Student student = Student
									.builder()
									.name(name)
									.email(name+"@"+faker.internet()
									.domainName())
									.age(faker.number().numberBetween(18, 50))
									.build();
			this.studentRepository.save(student);
		}
	}

}
