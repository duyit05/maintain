package com.review.monkey.security.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.hibernate.validator.constraints.UUID;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity(name = "invalidated_token")
public class InvalidatedToken {
    @Id
    @UUID
    String id;

    Date expiryTime;
}
