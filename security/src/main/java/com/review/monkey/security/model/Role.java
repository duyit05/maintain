package com.review.monkey.security.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.review.monkey.security.model.mapping.RolePermission;
import com.review.monkey.security.model.mapping.UserRole;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    String roleId;

    @Column(name = "role_name")
    String roleName;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<UserRole> roleUsers = new ArrayList<>();

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<RolePermission> rolePermission = new ArrayList<>();
}
