package com.springboot1.helloworld.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {

        return studentRepository.findAll();

//        return List.of(
//                new Student(1L, "jack", "jack@mail.com", LocalDate.of(2000, Month.JANUARY, 1), 22),
//                new Student(2L, "marie", "marie@mail.com", LocalDate.of(2002, Month.FEBRUARY, 1), 20)
//        );
    }

}
