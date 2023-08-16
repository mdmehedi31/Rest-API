package com.rest.restapi.dto.request;


import com.rest.restapi.entity.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentRequest {

    private String studentName;
    private String email;
    private String location;
    private Long age;
    private Date createDate;
    private Date updateDate;
    private String department;
}
