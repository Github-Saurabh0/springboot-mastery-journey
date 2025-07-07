# 📅 Day 4: Spring Boot – Validation and Exception Handling

This project extends the previous Student Management API by adding **input validation**, **auto-generated IDs**, and **custom exception handling**.

---

## 🚀 Features

- ✅ Auto-generate primary keys using `@GeneratedValue`
- ✅ Validate request data using `@NotNull`, `@Size`
- ✅ Return meaningful error messages using custom exceptions
- ✅ Global exception handling using `@ControllerAdvice`

---

## 📁 Key Files Added or Modified

```
src/
├── model/
│   └── Student.java                  # Added validation and @GeneratedValue
├── service/
│   └── StudentService.java          # Throws StudentNotFoundException
├── exception/
│   ├── StudentNotFoundException.java
│   └── GlobalExceptionHandler.java
```

---

## 🧱 Tech Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Bean Validation (JSR 380)

---

## ⚙️ Setup (Prerequisites)

Ensure the database `studentdb` is created and `application.properties` is configured as in Day 3.

Add this validation dependency in `pom.xml` (if not present):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

## 📦 Student.java (Updated)

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Course is required")
    private String course;

    // Getters and Setters
}
```

---

## 🧨 StudentNotFoundException.java

```java
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
```

---

## 🛡️ GlobalExceptionHandler.java

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n")
        );
        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
```

---

## 🔁 API Behavior

| Scenario | Result |
|----------|--------|
| Add student with missing name | `400 Bad Request` with validation message |
| Delete non-existent student | `404 Not Found` with custom error message |
| Get student with wrong ID | `404 Not Found` |
| Normal flow | CRUD works as expected |

---

## 🔬 Sample Postman Tests

### ✅ Add Valid Student (POST)
**POST** `/students`
```json
{
  "name": "Saurabh",
  "course": "Spring Boot"
}
```

### ❌ Invalid Add (Name too short)
```json
{
  "name": "",
  "course": "Java"
}
```

### ✅ Update Existing Student (PUT)
**PUT** `/students/1`
```json
{
  "id": 1,
  "name": "Updated",
  "course": "JPA"
}
```

### ❌ Update Non-existent Student
**PUT** `/students/9999` → 404 Not Found

### ✅ Delete Student
**DELETE** `/students/1` → Success

### ❌ Delete Non-existent Student
**DELETE** `/students/9999` → 404 Not Found

---

## 👨‍💻 Author

**Saurabh Kushwaha**  
[LinkedIn](https://www.linkedin.com/in/saurabh884095/)  
[GitHub](https://github.com/Github-Saurabh0)
