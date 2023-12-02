package com.jay.api.controller;

import com.jay.api.entity.Student;
import com.jay.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "Student deleted successfully";
    }


}
