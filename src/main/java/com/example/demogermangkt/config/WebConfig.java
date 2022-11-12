package com.example.demogermangkt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


//@EnableWebMvc
//@PropertySource(value = { "classpath:application.properties" })
public class WebConfig{
    /* implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String []s = new String[]{"/api/v1","/actuator/**"};
        http.cors().and().csrf().disable()
                .authorizeRequests().
                 antMatchers(s).permitAll();
        return http.build();
    }*/
}
