package com.rest.restapi.controller.definition;


import com.rest.restapi.entity.Student;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student-list")
@CrossOrigin("*")
public interface StudentControllerDef {



    @RequestMapping("/create")
    ResponseEntity<Student> createStudent(@Valid @RequestBody Student student);

    @RequestMapping("/get-by-id/{stId}")
    ResponseEntity<Student> getStudentById(@PathVariable Long stId);

    @PutMapping("/update-student")
    ResponseEntity<Student> updateStudent(@RequestParam Long stdId, @RequestBody Student student);
    @RequestMapping("/get-by-name")
    ResponseEntity<List<Student>>  getByStudentName(@RequestParam String name);

    @RequestMapping("/get-by-name-location")
    ResponseEntity<List<Student>> getByStudentNameAndLocation(@RequestParam String name, @RequestParam String location);

    @RequestMapping("/get-by-name-keyword")
    ResponseEntity<List<Student>> getByStudentNameKeyword(@RequestParam String keyword);

    @RequestMapping("/get-all")
    ResponseEntity<List<Student>> getAllStudent(@RequestParam int pageNumber, @RequestParam int pageNo);

    @RequestMapping("/get-student/{name}/{location}")
    ResponseEntity<List<Student>> getStudentByNameOrLocation(@PathVariable String name, @PathVariable String location);


    @RequestMapping("/find-all-student")
    ResponseEntity<List<Student>> findAllStudent();


}
