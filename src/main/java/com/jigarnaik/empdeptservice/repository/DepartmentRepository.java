package com.jigarnaik.empdeptservice.repository;

import com.jigarnaik.empdeptservice.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
