### 📅 Day 6: Custom Login Page with Spring Security

Today we customized the default Spring Security login page with our own HTML form and integrated it into our secured Spring Boot application.

---

### ✅ What We Did

- Created a custom HTML login form
- Handled login failure and logout
- Configured Spring Security to use the custom page
- Defined role-based access (basic)
- Updated security settings in `SecurityConfig.java`

---

### 📁 Project Structure

```
Day-6-Custom-Login-Security/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── wearl/
│   │   │           └── HelloSpringBoot/
│   │   │               ├── Application.java
│   │   │               ├── config/
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── controller/
│   │   │               │   └── StudentController.java
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── StudentNotFoundException.java
│   │   │               ├── model/
│   │   │               │   └── Student.java
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               └── service/
│   │   │                   └── StudentService.java
│   └── resources/
│       ├── application.properties
│       ├── templates/
│       │   ├── login.html    ✅ (custom login page)
│       │   └── error.html    ✅ (optional custom error)
│       └── static/
├── pom.xml
└── nbactions.xml
```

---

### 🛡️ Custom Login Page (`templates/login.html`)

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form th:action="@{/login}" method="post">
        <label>Username:</label>
        <input type="text" name="username"/><br/>
        <label>Password:</label>
        <input type="password" name="password"/><br/>
        <button type="submit">Login</button>
    </form>
    <p th:if="${param.error}">Invalid username or password.</p>
    <p th:if="${param.logout}">You have been logged out.</p>
</body>
</html>
```

---

### 🔐 `SecurityConfig.java`

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/students/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
            .username("wearl")
            .password("{noop}pass123")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
```

---

### 🔑 Login Credentials

- **Username:** `wearl`
- **Password:** `pass123`

---

### 🚀 To Run

```bash
mvn spring-boot:run
```

Then open [http://localhost:8080/students](http://localhost:8080/students) — you'll be redirected to the custom login page.

---

## 👨‍💻 Author

**Saurabh Kushwaha**  
[LinkedIn](https://www.linkedin.com/in/saurabh884095/)  
[GitHub](https://github.com/Github-Saurabh0)