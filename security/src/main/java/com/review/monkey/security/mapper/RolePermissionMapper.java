package com.review.monkey.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.review.monkey.security.model.mapping.RolePermission;
import com.review.monkey.security.response.RolePermissionResponse;

@Mapper(componentModel = "spring")
public interface RolePermissionMapper {

    @Mapping(source = "role.roleId", target = "roleId")
    @Mapping(source = "permission.permissionId", target = "permissionId")
    RolePermissionResponse toRolePermissionResponse(RolePermission rolePermission);
}
