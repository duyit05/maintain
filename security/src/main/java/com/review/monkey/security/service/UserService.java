package com.review.monkey.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.review.monkey.security.request.UserRequest;
import com.review.monkey.security.request.UserSearchRequest;
import com.review.monkey.security.request.update.UserUpdateRequest;
import com.review.monkey.security.response.UserResponse;

@Service
public interface UserService {
    List<UserResponse> getAllUser();

    UserResponse createUser(UserRequest request);

    void deleteUser(String userId);

    UserResponse updateUser(String userId, UserRequest request);

    UserResponse getUserById(String userId);

    UserResponse getMyInfoOrUpdate(UserUpdateRequest request);

    UserResponse getMyInfoView();

    Page<UserResponse> getUserPagingAndSearch(UserSearchRequest request);
}
