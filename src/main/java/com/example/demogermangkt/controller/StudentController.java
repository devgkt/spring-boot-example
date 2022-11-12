package com.example.demogermangkt.controller;

import com.example.demogermangkt.service.StudentService;
import com.example.demogermangkt.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    //get by name
    @GetMapping(path = "/student/{name}")
    public List<Student> getStudent(@PathVariable String name){
        return  studentService.getByName(name);
    }

    //get by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Student>  findStudent(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findStudentById(id);
        if(studentOptional.isPresent()){
            return new ResponseEntity<>(studentOptional.get(),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //get all
    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.getAllStudents();
    }

    // post save
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s = studentService.addStudent(student);
        return new ResponseEntity(s,HttpStatus.CREATED);
    }

    //PUT update
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student s = studentService.updateStudent(student);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    //PUT with ID
    @PutMapping("/{id}")
    public void updateStudent(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);
    }

    //patch
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Map<String,String> updates, @PathVariable Long id){
        Optional<Student> s = studentService.updateStudent(updates,id);
        return new ResponseEntity<>(s.get(), HttpStatus.OK);
    }

    //delete delete
    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
