package com.review.monkey.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.review.monkey.security.model.Role;
import com.review.monkey.security.request.RoleRequest;
import com.review.monkey.security.response.RoleResponse;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    void updateRole(@MappingTarget Role role, RoleRequest request);
}
