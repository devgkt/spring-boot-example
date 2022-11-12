package com.example.demogermangkt.service;

import com.example.demogermangkt.repository.StudentRepository;
import com.example.demogermangkt.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    //get by name
    public List<Student> getByName(String name){
        return  studentRepository.getSome(name);
    }

    public List<Student> getAllStudents(){
        Iterable<Student> users = studentRepository.findAll();
        List<Student> list = new ArrayList<Student>();
        users.forEach(list::add);
        return list;
    }
    public Student addStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return  studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id){
        return Optional.ofNullable(studentRepository.findById(id)).get();
    }


    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with id "+id+" does not exist");
        }
        studentRepository.deleteById(id);
    }

    public Optional<Student>  updateStudent(Map<String, String> updates, Long id) {
        //updates.forEach((k,v)->{
        //    System.out.println("key: "+k+" , value: "+v);
        //});
        Optional<Student> studentOptional = findStudentById(id);
        if(studentOptional.isPresent()){
            Student newStudent = studentOptional.get();
            //update
            String name = updates.get("name");
            String email = updates.get("email");
            String updatedDate =updates.get("dob");
            if(name != null && name.length() > 0 && !Objects.equals(newStudent.getName(),name)){//valid name
                newStudent.setName(name);
            }

            if(email != null && email.length() > 0 && !Objects.equals(newStudent.getEmail(),email)){//valid email
                Optional<Student> emailStudent = studentRepository.findStudentByEmail(email);

                if(emailStudent.isPresent()){
                    throw new IllegalStateException("email taken");
                }
                newStudent.setEmail(email);
            }

            if(updatedDate != null && updatedDate.length() > 9){//valid dob 0000-00-00
                String newDate[] = updatedDate.split("-");
                LocalDate newDob = LocalDate.of(Integer.parseInt(newDate[0]), Integer.parseInt(newDate[1]), Integer.parseInt(newDate[2]));
                newStudent.setDob(newDob);
            }

            return Optional.of(studentRepository.save(newStudent));
        }else{
            throw new IllegalStateException("Student with id "+id+" does not exist");
        }
    }

    @Transactional
    public void updateStudent(Long id,String name,String email){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student updatedStudent = studentOptional.get();
            //update
            if(name != null && name.length() > 0 && !Objects.equals(updatedStudent.getName(),name)){
                updatedStudent.setName(name);
            }

            if(email != null && email.length() > 0 && !Objects.equals(updatedStudent.getEmail(),email)){
                Optional<Student> emailStudent = studentRepository.findStudentByEmail(email);

                if(emailStudent.isPresent()){
                    throw new IllegalStateException("email taken");
                }
                updatedStudent.setEmail(email);
            }
        }else{
            throw new IllegalStateException("Student with id "+id+" does not exist");
        }
    }
}
