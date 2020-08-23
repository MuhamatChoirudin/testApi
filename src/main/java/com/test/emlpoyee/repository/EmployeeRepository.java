package com.test.emlpoyee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.emlpoyee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	Optional<Employee> findById(String id);
}
