# 🧪 Day 9: Testing (JUnit + Mockito) - Spring Boot Mastery Journey

In this module, we focus on writing unit tests for the service and controller layers using **JUnit 5** and **Mockito**.

---

## ✅ What You’ll Learn

- Unit testing with JUnit 5
- Mocking dependencies using Mockito
- Writing tests for service layer
- Writing controller tests using `@WebMvcTest`
- Assertions and behavior verification
- Running all tests using Maven

---

## 🗂️ Project Structure

```
Day-9-Testing/
├── src/
│   ├── main/
│   │   └── java/com/wearl/HelloSpringBoot/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── mapper/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── Application.java
│   └── test/
│       └── java/com/wearl/HelloSpringBoot/
│           ├── service/
│           │   └── StudentServiceTest.java
│           └── controller/
│               └── StudentControllerTest.java
├── pom.xml
```

---

## 🔬 Sample Test Files

### `StudentServiceTest.java`

- Tests service logic by mocking repository and mapper.

### `StudentControllerTest.java`

- Uses `MockMvc` and `@WebMvcTest` to test the HTTP layer.

---

## ⚙️ Required Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

---

## 🚀 How to Run Tests

```bash
mvn clean test
```

---

## ✅ Output

- Console logs for test execution.
- Status code and JSON validation for controller tests.

---

🔗 Need more help or Java tricks? [linkedin.com/in/saurabh884095](https://www.linkedin.com/in/saurabh884095/)