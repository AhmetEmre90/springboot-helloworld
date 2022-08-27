package com.springboot1.helloworld.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(Sort.by("id"));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken, enter different email");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("student doesn't exist");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("student doesn't exist");
        }

        if (name != null && name.length() > 0 && !Objects.equals(studentOptional.get().getName(), name)) {
            studentOptional.get().setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(studentOptional.get().getEmail(), email)) {
            if (studentRepository.findStudentByEmail(email).isPresent()) {
                throw new IllegalStateException("email taken, can't update the email");
            }
            studentOptional.get().setEmail(email);
        }
    }
}
