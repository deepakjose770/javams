package com.dipak.userservice.controller;


import com.dipak.userservice.DTO.ResponseTemplateDTO;
import com.dipak.userservice.entity.Users;
import com.dipak.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateDTO getUserWithDepartment(@PathVariable("userId") Long userId) {
        return userService.getUserWithDepartment(userId);
    }
}
