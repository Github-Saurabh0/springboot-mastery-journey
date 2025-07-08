### 📅 Day 5 - Spring Security Fundamentals

✅ **What I Learned:**

- Introduction to Spring Security
- Added default HTTP Basic authentication
- Secured all endpoints using Spring Security
- Created a custom `SecurityConfig.java` file
- Configured in-memory user credentials
- Explored method-level security annotations

✅ **Project Structure Updates:**

```
Day-5-Spring-Security-Fundamentals/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── wearl/
│   │   │           └── HelloSpringBoot/
│   │   │               ├── Application.java
│   │   │               ├── controller/
│   │   │               │   └── StudentController.java
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── StudentNotFoundException.java
│   │   │               ├── model/
│   │   │               │   └── Student.java
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               ├── service/
│   │   │               │   └── StudentService.java
│   │   │               └── config/
│   │   │                   └── SecurityConfig.java   ✅ (NEW for Day 5)
│   │   └── resources/
│   │       ├── application.properties   ✅ (updated with username/password)
│   │       ├── static/
│   │       └── templates/
│
├── pom.xml   ✅ (added spring-boot-starter-security)
└── nbactions.xml

```

✅ **application.properties** changes:

```properties
spring.security.user.name=admin
spring.security.user.password=admin123
```

✅ **SecurityConfig.java** (Basic Setup)(Disable Security for Development (Optional)):

```java
package com.wearl.HelloSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // for testing POST without CSRF token
            .authorizeHttpRequests(auth -> 
                auth.anyRequest().authenticated()
            )
            .httpBasic(); // Enables basic auth

        return http.build();
    }
}
```

🧪 **How I Tested:**

- 🔐 Tried accessing `POST /students` via Postman → prompted for username & password
- ✅ Entered correct credentials → request succeeded
- ❌ Entered wrong credentials → 401 Unauthorized

---

## 👨‍💻 Author

**Saurabh Kushwaha**  
[LinkedIn](https://www.linkedin.com/in/saurabh884095/)  
[GitHub](https://github.com/Github-Saurabh0)