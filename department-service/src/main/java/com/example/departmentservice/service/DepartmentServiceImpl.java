package com.example.departmentservice.service;

import com.example.departmentservice.exception.DepartmentNotFoundException;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.request.DepartmentRequest;
import com.example.departmentservice.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setDepartmentCode(departmentRequest.getDepartmentCode());
        department = departmentRepository.save(department);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setDepartmentCode(department.getDepartmentCode());
        return departmentResponse;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Not Found"));
    }


}
