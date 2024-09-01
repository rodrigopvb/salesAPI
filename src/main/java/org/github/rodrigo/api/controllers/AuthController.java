package org.github.rodrigo.api.controllers;

import org.github.rodrigo.api.dto.UserDTO;
import org.github.rodrigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> getUser(@RequestBody UserDTO userDTO) {
        String token = userService.authenticateUser(userDTO);
        if(token != null){
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}

