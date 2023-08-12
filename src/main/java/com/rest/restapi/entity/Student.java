package com.rest.restapi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stdId;

    @NotEmpty(message = "Student name should not be null")
    private String studentName;

    @Email(message = "email invalid")
    private String email;
    @NotBlank(message = "location should not be empty")
    private String location;
    private Long age=0L;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Date updateDate;
}
