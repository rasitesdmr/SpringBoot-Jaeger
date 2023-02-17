package com.example.departmentservice.service;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.request.DepartmentRequest;
import com.example.departmentservice.response.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest departmentRequest);



    Department getDepartmentById(Long id);


}
