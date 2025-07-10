package com.wearl.HelloSpringBoot.controller;

import org.springframework.web.bind.annotation.*;
import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String add(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
