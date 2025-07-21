package com.wearl.HelloSpringBoot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wearl.HelloSpringBoot.dto.StudentDTO;
import com.wearl.HelloSpringBoot.service.StudentServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService; // ✅ use @MockBean instead of @Mock

    @Test
    public void testGetStudentById() throws Exception {
        StudentDTO dto = new StudentDTO(1, "John", "john@example.com", "Computer Science");

        when(studentService.getStudentById(1)
        ).thenReturn(dto);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }
}
