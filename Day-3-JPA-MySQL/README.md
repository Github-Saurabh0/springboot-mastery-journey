# 📅 Day 3: Spring Boot + JPA + MySQL Integration

This project demonstrates how to use **Spring Boot**, **Spring Data JPA**, and **MySQL** together to build a RESTful API for managing students.

---

## 🚀 Features

- ✅ Connects Spring Boot app with MySQL using Spring Data JPA
- ✅ Create, Read, Update, Delete (CRUD) operations on `Student` entity
- ✅ REST APIs for managing students
- ✅ Auto table creation with Hibernate
- ✅ Data persistence to MySQL DB

---

## 🧱 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 📁 Project Structure

```
Day-3-JPA-MySQL/
├── controller/
│   └── StudentController.java
├── model/
│   └── Student.java
├── repository/
│   └── StudentRepository.java
├── service/
│   └── StudentService.java
├── Application.java
├── application.properties
└── pom.xml
```

---

## ⚙️ Setup Instructions

### 1. ✅ MySQL Setup

Create a database:

```sql
CREATE DATABASE studentdb;
```

### 2. ✅ Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

### 3. ✅ Add Dependencies in `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

## 🧪 API Endpoints

| Method | Endpoint            | Description            |
|--------|---------------------|------------------------|
| GET    | `/students`         | Get all students       |
| POST   | `/students`         | Add a new student      |
| PUT    | `/students/{id}`    | Update student by ID   |
| DELETE | `/students/{id}`    | Delete student by ID   |

### ✅ Sample JSON for POST/PUT:

```json
{
  "id": 1,
  "name": "Saurabh",
  "course": "Spring Boot"
}
```

---

## 📌 Sample Success Response

```
Student added successfully!
```

---

## 📤 Run the Project

```bash
mvn spring-boot:run
```

Open browser:
```
http://localhost:8080/students
```

---

## 👨‍💻 Author

**Saurabh Kushwaha**  
[LinkedIn](https://www.linkedin.com/in/saurabh884095/)  
[GitHub](https://github.com/Github-Saurabh0)

---

## 📌 Commit History (Best Practice)

```bash
✅ pom.xml              → Add JPA, MySQL, Web dependencies
✅ application.properties → Configure MySQL DB
✅ Student.java         → Create JPA Entity
✅ StudentRepository    → Interface for DB operations
✅ StudentService       → Logic for CRUD using repository
✅ StudentController    → REST endpoints
✅ Application.java     → Main entry point
✅ README.md            → Project instructions and setup
```