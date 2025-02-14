package dev.kiyoshi.spring_boot_neo4j.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.kiyoshi.spring_boot_neo4j.models.User;
import dev.kiyoshi.spring_boot_neo4j.object.UserDTO;
import dev.kiyoshi.spring_boot_neo4j.requests.CreateUserRequest;
import dev.kiyoshi.spring_boot_neo4j.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public String loggedInUserDetails(Principal principal) {
        return principal.getName();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);

        UserDTO responseUser = new UserDTO(user.getName(), user.getUsername(), user.getRoles());

        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }
}
