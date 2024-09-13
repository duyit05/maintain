package com.review.monkey.security.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import com.review.monkey.security.request.AuthenticationRequest;
import com.review.monkey.security.request.IntrospectRequest;
import com.review.monkey.security.request.LogoutRequest;
import com.review.monkey.security.request.RefreshTokenRequest;
import com.review.monkey.security.response.AuthenticationResponse;
import com.review.monkey.security.response.IntrospectResponse;

@Service
public interface AuthenticationService {
    AuthenticationResponse authentication(AuthenticationRequest request) throws JOSEException;

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

    void logout(LogoutRequest request) throws ParseException, JOSEException;

    SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException;

    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException;

    AuthenticationResponse outboundAuthentication (String code);
}
