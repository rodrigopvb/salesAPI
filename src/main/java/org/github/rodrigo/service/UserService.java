package org.github.rodrigo.service;

import lombok.Getter;
import org.github.rodrigo.api.dto.UserDTO;
import org.github.rodrigo.entity.User;
import org.github.rodrigo.repository.UserRepository;
import org.github.rodrigo.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword((passwordEncoder.encode(user.getPassword())));
        User savedUser = userRepository.save((user));
        return  modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }

    public String authenticateUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if(user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())){
            System.out.println("Password matches");
            return jwtUtil.generateToken(user.getUsername());
        }
        return null;
    }
}

