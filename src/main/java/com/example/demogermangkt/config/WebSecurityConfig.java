package com.example.demogermangkt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/*import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;*/
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig  {
    /*protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests().antMatchers("/").permitAll();
        http.csrf().disable();
    }*/

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        //return http.cors().and().csrf().disable().requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((requests) ->
        //        requests.anyRequest().permitAll());

        http.cors().and().csrf().disable()
                .authorizeRequests().
                 antMatchers("/api/v1").permitAll();
        return http.build();
    }*/
}
