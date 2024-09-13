package com.review.monkey.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.monkey.security.model.InvalidatedToken;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {}
