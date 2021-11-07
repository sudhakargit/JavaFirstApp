package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;


@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("saveDepartment");
		return service.saveDepartment(department);
	}
	@GetMapping("/departments")
	public List<Department> fetchDepartmentsList(){
		return service.fetchDepartmentsList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return service.fetchDepartmentById(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		service.deleteDepartmentById(departmentId);
		return  "Department is deleted successfully!";
	}
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		return service.updateDepartmentById(departmentId,department);
	}
	public Department fetchDepartmentById(@PathVariable("name") String departmentName) {
		return service.fetchDepartmentById(departmentName);
	}
}
