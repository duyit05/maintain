package com.review.monkey.security.service;

import org.springframework.stereotype.Service;

import com.review.monkey.security.model.User;

@Service
public interface JwtService {
    String generateToken(User user);

    String buildScope(User user);
}
