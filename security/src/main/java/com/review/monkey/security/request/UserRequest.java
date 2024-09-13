package com.review.monkey.security.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.review.monkey.security.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequest {

    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, message = "PASSWORD_INVALID")
    String password;

    // @Email (message = "Format email not true")
    String firstName;
    String lastName;

    @DobConstraint(min = 16, message = "DOB_INVALID")
    LocalDate dob;
}
