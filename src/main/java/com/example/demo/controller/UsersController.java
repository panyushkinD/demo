package com.example.demo.controller;

import com.example.demo.dto.UsersRequestDto;
import com.example.demo.dto.UsersResponseDto;
import com.example.demo.model.GenderName;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class UsersController {
    private final UsersService usersService;

    @GetMapping(value = "/all-users")
    public List<UsersResponseDto> getAllUsers() {
        return usersService.getAll();
    }
    @PostMapping(value = "/add-users")
    public void addUser(@RequestBody UsersRequestDto usersRequestDto) {
        usersService.addNewUser(usersRequestDto);
    }
    @GetMapping(value = "/find-users/{id}")
    public Users usersFind(@PathVariable int id) {
        return usersService.getUserById(id);
    }
}
