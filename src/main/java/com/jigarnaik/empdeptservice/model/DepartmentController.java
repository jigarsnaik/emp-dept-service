package com.jigarnaik.empdeptservice.model;

import com.jigarnaik.empdeptservice.exception.ResourceNotFoundException;
import com.jigarnaik.empdeptservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Department department = departmentService.findById(id);
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        Department savedDepartment = departmentService.save(department);
        return ResponseEntity.created(URI.create("/department/" + savedDepartment.getId())).body(savedDepartment);
    }

    @PutMapping
    public ResponseEntity<Department> update(@RequestBody Department department) throws ResourceNotFoundException {
        if (Objects.isNull(departmentService.findById(department.getId()))) {
            throw new ResourceNotFoundException("Department you're trying to update does not exist.");
        }
        Department savedDepartment = departmentService.save(department);
        return ResponseEntity.created(URI.create("/department/" + savedDepartment.getId())).body(savedDepartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Department> delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        if (Objects.isNull(departmentService.findById(id))) {
            throw new ResourceNotFoundException("Department you're trying to delete does not exist.");
        }
        departmentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

}
