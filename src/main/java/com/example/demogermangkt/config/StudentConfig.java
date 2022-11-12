package com.example.demogermangkt.config;

import com.example.demogermangkt.model.User;
import com.example.demogermangkt.repository.StudentRepository;
import com.example.demogermangkt.model.Student;
import com.example.demogermangkt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository, UserRepository userRepository){
        return args ->{
            System.out.println("Creating students");
            Student s = new Student("Andrea","g@a.com",
                    LocalDate.of(1996, Month.MARCH,29));
            Student s2 = new Student("Andrea","a@a.com",
                    LocalDate.of(1999, Month.OCTOBER,8));
            repository.save(s);
            repository.save(s2);
            repository.save(new Student("German","g@a.com",LocalDate.of(1989,Month.OCTOBER,10)));
            System.out.println("creating users");
            //create user
            User u = new User();
            u.setUsername("Pedro");
            u.setPassword("Hola");
            userRepository.save(u);
            userRepository.save(new User("Paramo","Hola"));

        };
    }
}
