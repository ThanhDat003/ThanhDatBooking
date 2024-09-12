package com.ThanhDatBooking.ThanhDatBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(nullable = false, length = 30)
    private String fullname;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    private LocalDate birth_date;

    @Column(length = 20)
    private String phone_number;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String avatar;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isActive = false;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isCompleteProfile = false;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;

    private enum Gender {
        Male, Female, Other
    }

    private enum Role {
        ADMIN, MANAGER, EMPLOYEE, USER
    }
}

//CREATE TABLE users(
//        user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        fullname NVARCHAR(30) NOT NULL,
//username VARCHAR(20) NOT NULL,
//password VARCHAR(255) DEFAULT NULL,
//email varchar(100) DEFAULT NULL,
//roll ENUM('ADMIN','MANAGER','EMPLOYEE','USER') DEFAULT NULL,
//gender ENUM('Male','Female','Other') DEFAULT NULL,
//birth_date DATE DEFAULT NULL,
//phone_number varchar(20) DEFAULT NULL,
//address TEXT DEFAULT NULL,
//avatar varchar(255) DEFAULT NULL,
//is_active tinyint(1) DEFAULT '1',
//is_profile_complete tinyint(1) DEFAULT '0',
//created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
//updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
//);