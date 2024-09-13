package com.review.monkey.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.review.monkey.security.model.mapping.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    // PARAM
    @Query("select u from user_role u where u.user.userId = ?1 and u.role.roleId = ?2")
    Optional<UserRole> findByUserAndRole(String userId, String roleId);

    //  Object
    // @Query("select u from UserRole u where u.user.userId = :#{#request.userId} and u.role.roleId =
    // :#{#request.roleId}")
    //  Optional<UserRole> findByUserAndRole(UserRoleRequest request);

    @Query("select u from user_role u where u.user.userId = ?1 and u.role.roleId = ?2 and u.userRoleId <> ?3 ")
    Optional<UserRole> findByUserAndRoleAnUserRoleId(String userId, String roleId, int userRoleId);
}
