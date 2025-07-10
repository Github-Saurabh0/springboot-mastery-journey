# 📦 Day 7 - Global Exception Handling (Advanced) | Spring Boot Mastery Journey

This project demonstrates advanced **Global Exception Handling** in Spring Boot using `@ControllerAdvice`, `@ExceptionHandler`, and custom error responses for centralized and professional error handling.

---

## ✅ Features Implemented

- 🎯 Global exception handler using `@ControllerAdvice`
- ⚠️ Custom exceptions like `ResourceNotFoundException`
- 📨 Structured error response using `ApiError`
- 📋 Handles:
  - Validation errors (`@Valid`)
  - Type mismatches
  - Unhandled global exceptions

---

## 📁 Project Structure

```
Day-7-Global-Exception-Handling/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── wearl/
│   │   │           └── HelloSpringBoot/
│   │   │               ├── HelloSpringBootApplication.java
│   │   │               ├── controller/
│   │   │               │   └── StudentController.java
│   │   │               ├── exception/
│   │   │               │   ├── ApiError.java
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               ├── model/
│   │   │               │   └── Student.java
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               └── service/
│   │   │                   └── StudentService.java
│   └── resources/
│       ├── application.properties
│       └── static/
├── pom.xml
└── nbactions.xml
```

---

## 🔧 How to Run

```bash
./mvnw spring-boot:run
```

URL: [http://localhost:8080/api/students](http://localhost:8080/api/students)

---

## 🧪 Sample Error Responses

### 🔍 Student Not Found (404)
```json
{
  "message": "Student not found with ID: 5",
  "details": "Resource Not Found",
  "timestamp": "2025-07-10T20:15:34.012"
}
```

### 🧾 Validation Failed (400)
```json
{
  "message": "Validation Failed",
  "details": "name: must not be blank, age: must be positive",
  "timestamp": "2025-07-10T20:17:21.777"
}
```

### 🔢 Type Mismatch (400)
```json
{
  "message": "Type Mismatch",
  "details": "Invalid type for parameter 'id'",
  "timestamp": "2025-07-10T20:20:00.123"
}
```

### 💥 Internal Server Error (500)
```json
{
  "message": "NullPointerException",
  "details": "Internal Server Error",
  "timestamp": "2025-07-10T20:22:45.666"
}
```

---

## 💡 Learning Outcomes

- Centralized error management in Spring Boot
- Custom and reusable error format
- Cleaner controller/service classes with no boilerplate try-catch

---

## 🙌 Author

**Saurabh Kushwaha**  
Java Developer | Spring Boot Enthusiast  
🔗 [LinkedIn](https://www.linkedin.com/in/saurabh884095/)  
📧 saurabh@wearl.co.in