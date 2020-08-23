package com.test.emlpoyee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String>{
	Optional<Branch> findById(String id);
}
