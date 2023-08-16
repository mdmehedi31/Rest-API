package com.rest.restapi.service.definition;

import com.rest.restapi.dto.request.StudentRequest;
import com.rest.restapi.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentRequest student);

    Student getByStId(Long stId);

    Student updateStudent(Student student);

    List<Student> findByName(String name);

    List<Student> getByStudentNameAndLocation(String name, String location);

    List<Student> getByStudentNameKeyword(String name);

    List<Student> getAll(int pageNumber, int pageNo);

    List<Student> getStudentByStudentNameOrLocation(String name, String location);

    List<Student> findAllStudent();

    Integer deleteByStudentName(String name);

    Student dtoToEntity(StudentRequest studentRequest);
}
