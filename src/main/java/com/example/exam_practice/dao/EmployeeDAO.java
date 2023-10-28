package com.example.exam_practice.dao;

import com.example.exam_practice.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeEntity> getAll();
    void createEmployee(EmployeeEntity employeeEntity);
}
