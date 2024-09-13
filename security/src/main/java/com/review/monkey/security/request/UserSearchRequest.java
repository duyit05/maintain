package com.review.monkey.security.request;

import org.springframework.data.jpa.domain.Specification;

import com.review.monkey.security.model.User;
import com.review.monkey.security.repository.specification.UserSpecification;
import com.review.monkey.security.util.FilterRequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSearchRequest extends FilterRequest<User> {
    String lastName;

    @Override
    public Specification<User> specification() {
        return UserSpecification.builder().withLastName(this.lastName).build();
    }
}
