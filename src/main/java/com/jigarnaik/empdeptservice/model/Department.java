package com.jigarnaik.empdeptservice.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dept")
@Validated
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dept_name")

    private String deptName;
    @Column(name = "loc")
    private String location;

    public Department() {
    }

    public Department(Long id, String deptName, String location) {
        this.id = id;
        this.deptName = deptName;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
