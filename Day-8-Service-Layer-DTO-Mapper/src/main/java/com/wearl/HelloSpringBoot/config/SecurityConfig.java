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
        .csrf().disable()
        .authorizeHttpRequests()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/students/**").authenticated()  // ✅ Secure /students
            .anyRequest().permitAll()
        .and()
        .httpBasic(); // ✅ Allow Basic Auth (like Postman)

    return http.build();
}

}
