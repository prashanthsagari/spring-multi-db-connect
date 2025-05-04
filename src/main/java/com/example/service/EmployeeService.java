package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oracle.entity.Employee;
import com.example.oracle.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

//	public EmployeeService(EmployeeRepository repository) {
//		this.repository = repository;
//	}
	
	
	

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public Optional<Employee> getById(Long id) {
		return repository.findById(id);
	}

	public Employee create(Employee emp) {
		return repository.save(emp);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Employee update(Long id, Employee emp) {
		return repository.findById(id).map(existing -> {
			existing.setName(emp.getName());
			existing.setAge(emp.getAge());
			existing.setDepartment(emp.getDepartment());
			return repository.save(existing);
		}).orElseThrow(() -> new RuntimeException("Employee not found"));
	}
}
