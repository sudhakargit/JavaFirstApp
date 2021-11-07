package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repository;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return repository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentsList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = repository.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department is not available");
		}
		return department.get();
	}
	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		 repository.deleteById(departmentId);
	}
	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department dbDept = repository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())) {
			dbDept.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dbDept.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())) {
			dbDept.setDepartmentCode(department.getDepartmentCode());
		}
		return repository.save(department);
	}
	@Override
	public Department fetchDepartmentById(String departmentName) {
		// TODO Auto-generated method stub
		return repository.findByDepartmentName(departmentName);
	}

}
