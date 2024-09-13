package com.review.monkey.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.review.monkey.security.request.RoleRequest;
import com.review.monkey.security.response.RoleResponse;

@Service
public interface RoleService {
    List<RoleResponse> getAllRole();

    RoleResponse createRole(RoleRequest request);

    RoleResponse updateRoleById(String roleId, RoleRequest request);

    void deleteRoleById(String roleId);

    RoleResponse getRoleById(String roleId);
}
