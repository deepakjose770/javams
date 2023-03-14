package com.dipak.userservice.service;

import com.dipak.userservice.DTO.Department;
import com.dipak.userservice.DTO.ResponseTemplateDTO;
import com.dipak.userservice.entity.Users;
import com.dipak.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public ResponseTemplateDTO getUserWithDepartment(Long userId) {
        ResponseTemplateDTO responseTemplateDTO  = new ResponseTemplateDTO();
        Users user = userRepository.findByUserId(userId);

        //Calling another MS
        Department department = restTemplate.getForObject(
                "http://localhost:9001/departments/" + user.getDepartmentId(),
                Department.class);
        responseTemplateDTO.setUser(user);
        responseTemplateDTO.setDepartment(department);
        return responseTemplateDTO;
    }
}
