package com.review.monkey.security.mapper;

import org.mapstruct.Mapper;

import com.review.monkey.security.model.mapping.UserRole;
import com.review.monkey.security.response.UserRoleResponse;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleResponse toUserRoleResponse(UserRole userRole);
}
