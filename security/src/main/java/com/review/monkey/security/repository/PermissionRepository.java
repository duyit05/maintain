package com.review.monkey.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.monkey.security.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    boolean existsByPermissionName(String permissionName);
}
