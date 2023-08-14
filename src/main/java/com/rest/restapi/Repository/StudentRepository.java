package com.rest.restapi.Repository;

import com.rest.restapi.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {


    List<Student> findByStudentName(String studentName);

    // Select * from tbStudent where studentName="" and location="";

    List<Student> findByStudentNameAndLocation(String studentName, String location);

    // list find by keyword

    List<Student> findByStudentNameContains(String keyword, Sort sort);


    Student save(Student student);

   Student findById(Long stId);


   @Query("From Student where studentName=:name OR location=:location")
   List<Student> getStudentByStudentNameAndLocation(@Param("name") String nm,@Param("location") String loc);
}
