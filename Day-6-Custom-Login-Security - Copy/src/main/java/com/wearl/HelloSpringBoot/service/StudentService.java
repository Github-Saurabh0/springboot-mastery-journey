/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.wearl.HelloSpringBoot.service;

import com.wearl.HelloSpringBoot.exception.StudentNotFoundException;
import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // 🔍 Get student by ID or throw custom exception
    public Student getStudentById(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }

    // ➕ Add a new student
    public void addStudent(Student student) {
        repo.save(student);
    }

    // 🔄 Update existing student
    public void updateStudent(int id, Student student) {
        if (repo.existsById(id)) {
            student.setId(id); // Important: ensure ID is set
            repo.save(student);
        } else {
            throw new StudentNotFoundException("Cannot update. Student not found with ID: " + id);
        }
    }

    // ❌ Delete a student
    public void deleteStudent(int id) {
        Student student = getStudentById(id); // Reuse validated fetch
        repo.delete(student);
    }

    // 📋 Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    
    
}
