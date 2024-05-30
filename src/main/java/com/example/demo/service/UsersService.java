package com.example.demo.service;

import com.example.demo.dto.UsersRequestDto;
import com.example.demo.dto.UsersResponseDto;
import com.example.demo.model.GenderName;
import com.example.demo.model.Users;
import com.example.demo.repository.GenderRepository;
import com.example.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final GenderRepository genderRepository;

    public List<UsersResponseDto> getAll() {
        return usersRepository.findAll().stream().map(
                users -> UsersResponseDto.builder()
                        .firstName(users.getFirstName())
                        .lastName(users.getLastName())
                        .patronymicName(users.getPatronymicName())
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .age(users.getAge())
                        .gender(users.getGenderName().getGenderName())
                        .build()

        ).collect(Collectors.toList());
    }

    public Users getUserById(int id) {
        return usersRepository.findUsersById(id);
    }

    public void addNewUser(UsersRequestDto usersRequestDto) {
        GenderName findGenderById = genderRepository.findById(usersRequestDto.getGender()).get();
        Users insertUser = Users.builder()
                .firstName(usersRequestDto.getFirstName())
                .lastName(usersRequestDto.getLastName())
                .patronymicName(usersRequestDto.getPatronymicName())
                .login(usersRequestDto.getLogin())
                .password(usersRequestDto.getPassword())
                .age(usersRequestDto.getAge())
                .genderName(findGenderById)
                .build();
        usersRepository.save(insertUser);
    }
    public Users deleteUsersById(int id) {
        return usersRepository.deleteById(id);
    }
}