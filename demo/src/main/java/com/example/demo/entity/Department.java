package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Department {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long departmentId;
@NotBlank(message = "Please add department name")
private String departmentName;
private String departmentAddress;
private String departmentCode;
}
