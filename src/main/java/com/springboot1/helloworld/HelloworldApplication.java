package com.springboot1.helloworld;

import com.springboot1.helloworld.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @GetMapping
    public List<Student> hello() {
        return List.of(
                new Student(1L, "jack", "jack@mail.com", LocalDate.of(2000, Month.JANUARY, 1), 22),
                new Student(2L, "marie", "marie@mail.com", LocalDate.of(2002, Month.FEBRUARY, 1), 20)
        );
    }

}
