package com.jay.api.service;


import com.jay.api.entity.Student;
import com.jay.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

        public Student save(Student student) {
            return studentRepository.save(student);
        }

        public List<Student> findAll() {
            return studentRepository.findAll();
        }

    public Student findById(int id) {
           // Optional<Student> student = studentRepository.findById(id);
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not available"));
    }

    public Student update(int id, Student student) {
        Optional<Student> findStudent = studentRepository.findById(id);
        if(!findStudent.isPresent()){
            throw new RuntimeException("Student is not available");
        }
        return studentRepository.save(student);
    }

    public void deleteById(int id) {
            // implement
    }
}


