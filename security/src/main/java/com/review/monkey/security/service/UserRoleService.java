package com.review.monkey.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.review.monkey.security.response.UserRoleResponse;

@Service
public interface UserRoleService {
    List<UserRoleResponse> getAllUserAndRole();

    UserRoleResponse createUserRole(String userId, String roleId);

    UserRoleResponse updateUserRole(int userRoleId, String roleId);

    void deleteUserRoleById(int userRoleId);
}
