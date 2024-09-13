package com.review.monkey.security.service;

import org.springframework.stereotype.Service;

import com.review.monkey.security.response.RolePermissionResponse;

@Service
public interface RolePermissionService {
    RolePermissionResponse createRoleAndPermission(String roleId, String permissionId);

    RolePermissionResponse updateRoleAndPermission(int rolePermssionId, String permissionId);

    void deleteroleAndPermissionById(int rolePermissionId);
}
