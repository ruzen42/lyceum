package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.controller.rest.ClassroomController;
import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Material;
import com.jvmd.lyceum_backend.service.ClassroomService;
import com.jvmd.lyceum_backend.service.JwtService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClassroomController.class)
class ClassroomControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean ClassroomService classroomService;
    @MockBean JwtService jwtService;
    @MockBean UserDetailsService userDetailsService;
    @MockBean AuthenticationProvider authenticationProvider;

    private Classroom makeClassroom(Long id, String title) {
        Classroom c = new Classroom();
        c.setId(id);
        c.setTitle(title);
        c.setHtmlContent("<section><h1>" + title + "</h1></section>");
        return c;
    }

    private Material makeMaterial(Long id, String title) {
        Material m = new Material();
        m.setId(id);
        m.setTitle(title);
        return m;
    }

    @Test
    @WithMockUser
    void getAll_authenticated_returns200() throws Exception {
        when(classroomService.getAll()).thenReturn(List.of(makeClassroom(1L, "Math")));

        mockMvc.perform(get("/api/classroom/get-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Math"));
    }

    @Test
    void getAll_unauthenticated_returns401or403() throws Exception {
        mockMvc.perform(get("/api/classroom/get-all"))
                .andExpect(status().is(org.hamcrest.Matchers.anyOf(
                        org.hamcrest.Matchers.is(401),
                        org.hamcrest.Matchers.is(403))));
    }

    @Test
    @WithMockUser
    void getById_found_returns200() throws Exception {
        when(classroomService.getById(1L)).thenReturn(makeClassroom(1L, "Math"));

        mockMvc.perform(get("/api/classroom/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Math"));
    }

    @Test
    @WithMockUser
    void getById_notFound_returns404() throws Exception {
        when(classroomService.getById(999L))
                .thenThrow(new EntityNotFoundException("Classroom not found: 999"));

        mockMvc.perform(get("/api/classroom/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.detail").value("Classroom not found: 999"));
    }

    @Test
    @WithMockUser
    void getHtml_found_returnsHtmlContent() throws Exception {
        when(classroomService.getById(1L)).thenReturn(makeClassroom(1L, "Math"));

        mockMvc.perform(get("/api/classroom/1/html"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("<h1>Math</h1>")));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void create_asAdmin_returns200() throws Exception {
        when(classroomService.create("Physics")).thenReturn(makeClassroom(2L, "Physics"));

        mockMvc.perform(post("/api/classroom/create")
                        .param("title", "Physics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Physics"));
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void create_asTeacher_returns403() throws Exception {
        mockMvc.perform(post("/api/classroom/create")
                        .param("title", "Physics"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void addMaterial_asTeacher_returns200() throws Exception {
        when(classroomService.addMaterial(eq(1L), any(), any(), any(), any()))
                .thenReturn(makeMaterial(1L, "Homework 1"));

        mockMvc.perform(multipart("/api/classroom/1/material")
                        .param("title", "Homework 1")
                        .param("description", "Due Friday"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Homework 1"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void addMaterial_asUser_returns403() throws Exception {
        mockMvc.perform(multipart("/api/classroom/1/material")
                        .param("title", "Homework 1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void deleteMaterial_asTeacher_returns204() throws Exception {
        doNothing().when(classroomService).deleteMaterial(1L);

        mockMvc.perform(delete("/api/classroom/material/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(roles = "USER")
    void deleteMaterial_asUser_returns403() throws Exception {
        mockMvc.perform(delete("/api/classroom/material/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void regenerateHtml_asAdmin_returns200() throws Exception {
        when(classroomService.regenerateHtml(1L)).thenReturn(makeClassroom(1L, "Math"));

        mockMvc.perform(post("/api/classroom/1/regenerate-html"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void regenerateHtml_asTeacher_returns403() throws Exception {
        mockMvc.perform(post("/api/classroom/1/regenerate-html"))
                .andExpect(status().isForbidden());
    }
}
