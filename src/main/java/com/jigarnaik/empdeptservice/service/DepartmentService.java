package com.jigarnaik.empdeptservice.service;

import com.jigarnaik.empdeptservice.exception.ResourceNotFoundException;
import com.jigarnaik.empdeptservice.model.Department;
import com.jigarnaik.empdeptservice.repository.DepartmentRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department findById(Long id) throws ResourceNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found."));
    }

    public List<Department> findAll() {
        return Streamable.of(departmentRepository.findAll()).toList();
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }


}
