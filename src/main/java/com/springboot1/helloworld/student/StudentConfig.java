package com.springboot1.helloworld.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student student1 = new Student("jack", "jack@mail.com", LocalDate.of(2000, JANUARY, 1), 22);
            Student student2 = new Student("michael", "michael@mail.com", LocalDate.of(2002, JANUARY, 1), 20);

            repository.saveAll(List.of(student1, student2));
        };
    }
}
