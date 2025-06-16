package com.example.spring.security.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Builder
@Table(name = "matrimony_details")
@AllArgsConstructor
@NoArgsConstructor
public class MatrimonyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "birthTime")
    private LocalTime birthTime;
    @Column(name = "education")
    private String education;
    @Column(name = "caste")
    private String caste;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "willingCaste")
    private String willingCaste;
    @Column(name = "fatherName")
    private String fatherName;
    @Column(name = "motherName")
    private String motherName;
    @Column(name = "siblingBoys")
    private int siblingBoys;
    @Column(name = "siblingGirls")
    private int siblingGirls;
    @Column(name = "motherBirthPlace")
    private String motherBirthPlace;
    @Column(name = "fatherBirthPlace")
    private String fatherBirthPlace;
    @Column(name = "height")
    private String height;
    @Column(name = "zodiacSign")
    private String zodiacSign;
    @Column(name = "nakshatra")
    private String nakshatra;
    @Column(name = "expectation")
    private String expectation;

}
