/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.wearl.HelloSpringBoot.service;

import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void addStudent(Student student) {
        repo.save(student);
    }

    public void updateStudent(int id, Student student) {
        if (repo.existsById(id)) {
            repo.save(student);
        }
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
