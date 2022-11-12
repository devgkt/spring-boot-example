package com.example.demogermangkt.service;


import com.example.demogermangkt.model.Student;
import com.example.demogermangkt.repository.StudentRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceV2 {
    @Autowired
    public StudentRepositoryV2 studentRepositoryV2;

    public List<Student> getAllStudents(){
        return studentRepositoryV2.findAll();
    }

    public List<Student> getStudentsByName(String name) {
        List<Student> responseEntity;
       return studentRepositoryV2.findStudentByName(name);

        //if(students)){
        //    responseEntity= new ResponseEntity<>(students, HttpStatus.FOUND);
        //}else {
        //    responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
       //return responseEntity;
    }


    public ResponseEntity<Student> getStudentsByEmail(String email) {
        ResponseEntity<Student> responseEntity;
        Optional<Student> student= Optional.ofNullable(studentRepositoryV2.findStudentByEmail(email).get());
        if(student.isPresent()){
            responseEntity= new ResponseEntity<>(student.get(), HttpStatus.FOUND);
        }else {
            responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
