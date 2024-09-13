package com.review.monkey.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.monkey.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByRoleName(String roleName);

    Optional<Role> findByRoleName(String roleName);
}
