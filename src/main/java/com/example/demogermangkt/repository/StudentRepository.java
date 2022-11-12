package com.example.demogermangkt.repository;

import com.example.demogermangkt.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> {
@Query(
            value = "SELECT * FROM student ORDER BY id DESC",
            nativeQuery = true)
    List<Student> getDesc(@Param("name") String name);

    @Query(
            value = "SELECT * FROM student WHERE name=:name",
            nativeQuery = true)
    List<Student> getSome(@Param("name") String name);

    //@Query("SELECT s FROM Student WHERE s.email=?1")

    Optional<Student> findStudentByEmail(String email);
}
