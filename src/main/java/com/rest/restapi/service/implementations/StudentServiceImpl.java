package com.rest.restapi.service.implementations;

import com.rest.restapi.Repository.DepartmentRepository;
import com.rest.restapi.Repository.StudentRepository;
import com.rest.restapi.dto.request.StudentRequest;
import com.rest.restapi.entity.Department;
import com.rest.restapi.entity.Student;
import com.rest.restapi.service.definition.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Student createStudent(StudentRequest student) {
        return this.studentRepository.save(dtoToEntity(student));
    }

    @Override
    public Student getByStId(Long stId) {

        return this.studentRepository.findById(stId);
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> findByName(String name) {

        return this.studentRepository.findByStudentName(name);
    }

    @Override
    public List<Student> getByStudentNameAndLocation(String name, String location) {
        return this.studentRepository.findByStudentNameAndLocation(name,location);
    }

    @Override
    public List<Student> getByStudentNameKeyword(String name) {
        Sort sort= Sort.by(Sort.Direction.ASC,"stdId");
        return this.studentRepository.findByStudentNameContains(name,sort);
    }

    @Override
    public List<Student> getAll(int pageNumber, int pageNo) {

        Pageable pages= PageRequest.of(pageNumber,pageNo, Sort.Direction.ASC,"stdId");
                return this.studentRepository.findAll(pages).getContent();
    }

    @Override
    public List<Student> getStudentByStudentNameOrLocation(String name, String location) {

        return this.studentRepository.getStudentByStudentNameAndLocation(name,location);
    }

    @Override
    public List<Student> findAllStudent() {

        return (List<Student>) this.studentRepository.findAll(Sort.by("age"));
    }

    @Override
    public Integer deleteByStudentName(String name) {

        return this.studentRepository.deleteByStudentName(name);
    }

    @Override
    public Student dtoToEntity(StudentRequest studentRequest) {

        Department department= new Department();
        department.setName(studentRequest.getDepartment());

        department=departmentRepository.save(department);

        Student student= new Student();
        student.setStudentName(studentRequest.getStudentName());
        student.setEmail(studentRequest.getEmail());
        student.setLocation(studentRequest.getLocation());
        student.setAge(studentRequest.getAge());
        student.setDeptId(department);
        student.setCreateDate(new Date());

        return student;
    }
}
