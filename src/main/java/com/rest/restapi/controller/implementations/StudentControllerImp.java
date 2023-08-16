package com.rest.restapi.controller.implementations;

import com.rest.restapi.controller.definition.StudentControllerDef;
import com.rest.restapi.dto.request.StudentRequest;
import com.rest.restapi.entity.Student;
import com.rest.restapi.service.definition.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentControllerImp implements StudentControllerDef {


    @Autowired
    private StudentService service;

    @Override
    public ResponseEntity<Student> createStudent(StudentRequest student) {
        return new ResponseEntity<>(this.service.createStudent(student), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student> getStudentById( Long stId) {
        return new ResponseEntity<>(this.service.getByStId(stId), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Student> updateStudent(Long stdId,Student student) {

        student.setStdId(stdId);
        return new ResponseEntity<>(service.updateStudent(student), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Student>> getByStudentName(String name) {

        return new ResponseEntity<List<Student>>(service.findByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getByStudentNameAndLocation(String name, String location) {

        return new ResponseEntity<List<Student>>(service.getByStudentNameAndLocation(name,location), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getByStudentNameKeyword(String keyword) {

        return new ResponseEntity<List<Student>>(service.getByStudentNameKeyword(keyword), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudent(int pageNumber, int pageNo) {

        return new ResponseEntity<List<Student>>(service.getAll(pageNumber,pageNo),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getStudentByNameOrLocation(String name, String location) {

        return new ResponseEntity<List<Student>>(service.getStudentByStudentNameOrLocation(name,location), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> findAllStudent() {

        return new ResponseEntity<List<Student>>(service.findAllStudent(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteByStudentName(String name) {

        return new ResponseEntity<String>(service.deleteByStudentName(name)+" No. student is deleted", HttpStatus.OK);
    }
}
