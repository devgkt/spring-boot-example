package com.example.demogermangkt.controller;

import com.example.demogermangkt.model.Student;
import com.example.demogermangkt.service.StudentServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/students")
public class StudentControllerV2 {

    @Autowired
    StudentServiceV2 studentService;

    @GetMapping(path = "/student/{name}")//api/v2/students/name
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentsByName(name);

    }

    @GetMapping(path = "/{email}")//api/v2/students/email
    public ResponseEntity<Student> getStudentByEmail(String email){
        return studentService.getStudentsByEmail(email);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
