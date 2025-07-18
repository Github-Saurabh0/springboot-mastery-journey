package com.wearl.HelloSpringBoot.mapper;

import com.wearl.HelloSpringBoot.dto.StudentDTO;
import com.wearl.HelloSpringBoot.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
    List<StudentDTO> toDTOList(List<Student> students);
}
