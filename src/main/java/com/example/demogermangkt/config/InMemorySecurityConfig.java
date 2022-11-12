package com.example.demogermangkt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        //permit two users
        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("pass")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder().encode("pass")).roles("USER");
    }*/
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        //para los apis bajo /swagger-ui/ se requiere autenticacion basic y role ADMIN
        //para los apis bajo /api/v1/students solo se requiere autenticacion basic
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/api/v1**").permitAll().anyRequest().authenticated().and().httpBasic();
    }
}
