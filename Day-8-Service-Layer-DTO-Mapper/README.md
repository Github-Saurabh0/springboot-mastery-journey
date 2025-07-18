# Spring Boot - Service Layer with DTO and MapStruct (Day 8)

This project demonstrates a clean layered architecture using:

- Spring Boot
- RESTful API with CRUD for `Student`
- DTO pattern
- MapStruct for entity-to-DTO mapping
- Custom Exceptions and Exception Handling

---

## Project Structure

```
Day-8-Service-Layer-DTO-Mapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/wearl/HelloSpringBoot/
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       ├── dto/                     ✅ (NEW)
│   │   │       │   └── StudentDTO.java
│   │   │       ├── mapper/                  ✅ (NEW)
│   │   │       │   └── StudentMapper.java
│   │   │       ├── model/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       ├── service/
│   │   │       │   ├── StudentService.java
│   │   │       └── Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml

```

---

## API Endpoints

| Method | URL               | Description         |
|--------|-------------------|---------------------|
| GET    | `/students`       | Get all students    |
| POST   | `/students`       | Add new student     |
| PUT    | `/students/{id}`  | Update student      |
| DELETE | `/students/{id}`  | Delete student      |

---

## Run Instructions

```bash
mvn spring-boot:run
```

Ensure the main class is:

```java
com.wearl.HelloSpringBoot.Application
```

---

## Tools Used

- Java 17+
- Spring Boot
- MapStruct
- Maven

---

## Author

Saurabh Kushwaha (Wearl Technologies)

🔗 [LinkedIn](https://www.linkedin.com/in/saurabh884095)
