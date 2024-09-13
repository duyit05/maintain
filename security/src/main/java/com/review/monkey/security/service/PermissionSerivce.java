package com.review.monkey.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.review.monkey.security.request.PermissionRequest;
import com.review.monkey.security.response.PermissionResponse;

@Service
public interface PermissionSerivce {
    List<PermissionResponse> getAllPermission();

    PermissionResponse createPermission(PermissionRequest request);

    PermissionResponse updatePermissionById(String permissionId, PermissionRequest request);

    void deletePermissionById(String permissionId);

    PermissionResponse getPermissionById(String permissionId);
}
