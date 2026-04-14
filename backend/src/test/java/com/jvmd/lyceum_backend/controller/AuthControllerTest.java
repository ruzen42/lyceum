package com.jvmd.lyceum_backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.payload.AuthResponse;
import com.jvmd.lyceum_backend.payload.LoginRequest;
import com.jvmd.lyceum_backend.payload.RegisterRequest;
import com.jvmd.lyceum_backend.service.AuthService;
import com.jvmd.lyceum_backend.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @MockBean AuthService authService;
    @MockBean JwtService jwtService;
    @MockBean UserDetailsService userDetailsService;
    @MockBean AuthenticationProvider authenticationProvider;

    private final AuthResponse sampleResponse = AuthResponse.builder()
            .token("test-token")
            .username("john")
            .email("john@example.com")
            .roles(Set.of(Role.ROLE_USER))
            .build();

    @Test
    void register_success_returns201() throws Exception {
        when(authService.register(any())).thenReturn(sampleResponse);

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new RegisterRequest("john", "john@example.com", "secret123"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.token").value("test-token"))
                .andExpect(jsonPath("$.username").value("john"));
    }

    @Test
    void register_blankFields_returns400() throws Exception {
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new RegisterRequest("", "", ""))))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400));
    }

    @Test
    void register_duplicateUsername_returns409() throws Exception {
        when(authService.register(any()))
                .thenThrow(new IllegalArgumentException("Username already taken"));

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new RegisterRequest("john", "john@example.com", "secret123"))))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.detail").value("Username already taken"));
    }

    @Test
    void login_success_returns200() throws Exception {
        when(authService.login(any())).thenReturn(sampleResponse);

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new LoginRequest("john", "secret123"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("test-token"))
                .andExpect(jsonPath("$.roles[0]").value("ROLE_USER"));
    }

    @Test
    void login_wrongCredentials_returns401() throws Exception {
        when(authService.login(any()))
                .thenThrow(new BadCredentialsException("Bad credentials"));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new LoginRequest("john", "wrong"))))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.detail").value("Invalid username or password"));
    }

    @Test
    void login_blankFields_returns400() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new LoginRequest("", ""))))
                .andExpect(status().isBadRequest());
    }
}
