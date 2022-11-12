package com.example.demogermangkt.repository;

import com.example.demogermangkt.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    //JPQL
    @Query("SELECT u.username FROM User u WHERE u.username like '%rodriguez'")
    public Page<String> findUsernames(Pageable pageable);
}
