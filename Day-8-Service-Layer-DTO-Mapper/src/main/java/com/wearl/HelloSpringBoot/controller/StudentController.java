package com.wearl.HelloSpringBoot.controller;

import com.wearl.HelloSpringBoot.dto.StudentDTO;
import com.wearl.HelloSpringBoot.mapper.StudentMapper;
import com.wearl.HelloSpringBoot.model.Student;
import com.wearl.HelloSpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public List<StudentDTO> getAll() {
        List<Student> students = studentService.getAllStudents();
        return studentMapper.toDTOList(students);
    }

    @PostMapping
    public String add(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @Valid @RequestBody StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        studentService.updateStudent(id, student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
