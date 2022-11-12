package com.example.demogermangkt.config;

import com.example.demogermangkt.model.User;
import com.example.demogermangkt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GktUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        System.out.println("Attemping auth");
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            System.out.println("Attemping auth");
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword())).roles(new String[]{"ADMIN","USER"}).build();
        }else{
            throw new UsernameNotFoundException("Username "+username + " not found");
        }

    }

}
