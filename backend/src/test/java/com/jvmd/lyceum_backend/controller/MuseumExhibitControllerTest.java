package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.service.JwtService;
import com.jvmd.lyceum_backend.service.MuseumExhibitService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MuseumExhibitController.class)
class MuseumExhibitControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean MuseumExhibitService museumExhibitService;
    @MockBean JwtService jwtService;
    @MockBean UserDetailsService userDetailsService;
    @MockBean AuthenticationProvider authenticationProvider;

    private MuseumExhibit makeExhibit(Long id, String title) {
        MuseumExhibit e = new MuseumExhibit();
        e.setId(id);
        e.setTitle(title);
        e.setDescription("Desc");
        e.setHtmlContent("<section><h1>" + title + "</h1></section>");
        return e;
    }

    @Test
    @WithMockUser
    void getAll_returns200WithList() throws Exception {
        when(museumExhibitService.getAll()).thenReturn(List.of(makeExhibit(1L, "Rome")));

        mockMvc.perform(get("/api/museum-exhibit/get-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Rome"));
    }

    @Test
    @WithMockUser
    void getById_found_returns200() throws Exception {
        when(museumExhibitService.getById(1L)).thenReturn(makeExhibit(1L, "Rome"));

        mockMvc.perform(get("/api/museum-exhibit/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Rome"));
    }

    @Test
    @WithMockUser
    void getById_notFound_returns404() throws Exception {
        when(museumExhibitService.getById(999L))
                .thenThrow(new EntityNotFoundException("Exhibit not found: 999"));

        mockMvc.perform(get("/api/museum-exhibit/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.detail").value("Exhibit not found: 999"));
    }

    @Test
    @WithMockUser
    void getHtml_found_returnsHtmlContent() throws Exception {
        when(museumExhibitService.getById(1L)).thenReturn(makeExhibit(1L, "Rome"));

        mockMvc.perform(get("/api/museum-exhibit/1/html"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("<h1>Rome</h1>")));
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void create_asTeacher_returns200() throws Exception {
        when(museumExhibitService.create(any(), any(), any(), any()))
                .thenReturn(makeExhibit(1L, "Greece"));

        mockMvc.perform(multipart("/api/museum-exhibit/create")
                        .param("title", "Greece")
                        .param("description", "Ancient artifacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Greece"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void create_asUser_returns403() throws Exception {
        mockMvc.perform(multipart("/api/museum-exhibit/create")
                        .param("title", "Greece")
                        .param("description", "Ancient artifacts"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void regenerateHtml_asTeacher_returns200() throws Exception {
        when(museumExhibitService.regenerateHtml(1L)).thenReturn(makeExhibit(1L, "Rome"));

        mockMvc.perform(post("/api/museum-exhibit/1/regenerate-html"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(roles = "USER")
    void regenerateHtml_asUser_returns403() throws Exception {
        mockMvc.perform(post("/api/museum-exhibit/1/regenerate-html"))
                .andExpect(status().isForbidden());
    }
}
