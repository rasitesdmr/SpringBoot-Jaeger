package com.example.userservice.feignClients;

import com.example.userservice.response.DepartmentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service", url = "http://department-service:2001" )
public interface DepartmentFeignClient {

    @GetMapping(value = "/department/{id}")
    @CircuitBreaker(name = "userService")
    DepartmentResponse createUserGetDepartmentById(@PathVariable("id") Long id);

    @GetMapping(value = "/department/{id}")
    @CircuitBreaker(name = "userService", fallbackMethod = "getUserGetDepartmentById")
    DepartmentResponse getUserGetDepartmentById(@PathVariable("id") Long id);

    default DepartmentResponse getUserGetDepartmentById(Exception exception) {
        return new DepartmentResponse();
    }

}
