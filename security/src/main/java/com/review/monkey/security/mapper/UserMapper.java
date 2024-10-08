package com.review.monkey.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.review.monkey.security.model.User;
import com.review.monkey.security.request.UserRequest;
import com.review.monkey.security.request.update.UserUpdateRequest;
import com.review.monkey.security.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserRequest request);

    User toUserUpdate(UserUpdateRequest request);

    void updateUserInfo(@MappingTarget User user, UserUpdateRequest request);
}
