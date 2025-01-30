package org.example.solveusbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.solveusbackend.entity.User;
import org.example.solveusbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("사용자가 없습니다"));
    }
}
