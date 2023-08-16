package com.rest.restapi.Repository;

import com.rest.restapi.entity.Student;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    List<Student> findByStudentName(String studentName);
    // Select * from tbStudent where studentName="" and location="";
    List<Student> findByStudentNameAndLocation(String studentName, String location);
    // list find by keyword
    List<Student> findByStudentNameContains(String keyword, Sort sort);
    Student save(Student student);
   Student findByStdId(Long stId);
   @Query("From Student where studentName=:name OR location=:location")
   List<Student> getStudentByStudentNameAndLocation(@Param("name") String nm,@Param("location") String loc);


   @Transactional
   @Modifying
   @Query("DELETE FROM Student WHERE studentName=:studentName")
   Integer deleteByStudentName(@Param("studentName") String name);


   @Query("from Student where deptId.name=:name")
   List<Student> findByDeptId(String name);
}
