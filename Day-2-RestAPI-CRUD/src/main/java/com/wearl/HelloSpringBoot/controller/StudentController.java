/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wearl.HelloSpringBoot.controller;
import org.springframework.web.bind.annotation.*;
import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 *
 * @author Saurabh
 */
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
    public String add(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
