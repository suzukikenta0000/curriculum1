package com.example.userauthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userauthapp.model.User;
import com.example.userauthapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "メールアドレスはすでに登録されています";
        }

        // パスワードのハッシュ化
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "登録成功";
    }
}