package com.example.demogermangkt.repository;

import com.example.demogermangkt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepositoryV2 extends JpaRepository<Student,Long> {

    @Query(
            value = "SELECT * FROM student ORDER BY id DESC",
            nativeQuery = true)
    List<Student> getDesc(@Param("name") String name);

    @Query(
            value = "SELECT * FROM student WHERE name=:name",
            nativeQuery = true)
    List<Student> getSome(@Param("name") String name);

    public Optional<Student> findStudentByEmail(String email);
    public List<Student> findStudentByName(String name);

}
