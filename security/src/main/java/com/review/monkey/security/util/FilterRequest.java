package com.review.monkey.security.util;

import org.springframework.data.jpa.domain.Specification;

import com.review.monkey.security.request.PagingRequest;

import lombok.Data;

@Data
public abstract class FilterRequest<T> {
    private PagingRequest paging = new PagingRequest();

    public abstract Specification<T> specification();
}
