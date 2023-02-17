package com.example.userservice.service;


import com.example.userservice.exception.UserEmailAlreadyAvailableException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.feignClients.DepartmentFeignClient;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.request.UserCreateRequest;
import com.example.userservice.response.DepartmentResponse;
import com.example.userservice.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    DepartmentFeignClient departmentFeignClient;


    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {

        if (userRepository.existsByEmail(userCreateRequest.getEmail())) {
            log.error("{}", userCreateRequest.getEmail() + " email zaten mevcut !");
            throw new UserEmailAlreadyAvailableException(userCreateRequest.getEmail() + " email zaten mevcut !");
        }

        User user = new User();
        user.setFirstName(userCreateRequest.getFirstName());
        user.setLastName(userCreateRequest.getLastName());
        user.setEmail(userCreateRequest.getEmail());
        user.setDepartmentId(userCreateRequest.getDepartmentId());

        UserResponse userResponse = new UserResponse();
        userResponse.setDepartmentResponse(departmentFeignClient.createUserGetDepartmentById(userCreateRequest.getDepartmentId()));
        userRepository.save(user);

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());


        return userResponse;
    }

    @Override
    public UserResponse getByUserId(Long id) {
        if (!userRepository.existsById(id)) {
            log.error("{}", id + " numarları id sahip kullanıcı bulunamadı !");
            throw new UserNotFoundException(id + " numarları id sahip kullanıcı bulunamadı !");
        }
        User user = userRepository.getReferenceById(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setDepartmentResponse(getDepartmentById(user.getDepartmentId()));
        return userResponse;
    }
    public DepartmentResponse getDepartmentById(Long departmentId) throws IllegalArgumentException {
        return departmentFeignClient.getUserGetDepartmentById(departmentId);
    }
}
