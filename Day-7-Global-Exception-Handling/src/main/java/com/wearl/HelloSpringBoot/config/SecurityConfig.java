package com.wearl.HelloSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // ❗ important if you're testing via Postman
            .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll() // ✅ allow API calls
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")  
                .defaultSuccessUrl("/students", true)
                .permitAll()
            .and()
            .logout()
                .permitAll();

        return http.build();
    }
}
