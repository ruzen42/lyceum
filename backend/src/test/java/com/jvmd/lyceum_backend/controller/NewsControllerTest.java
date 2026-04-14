package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.service.JwtService;
import com.jvmd.lyceum_backend.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NewsController.class)
class NewsControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean NewsService newsService;
    @MockBean JwtService jwtService;
    @MockBean UserDetailsService userDetailsService;
    @MockBean AuthenticationProvider authenticationProvider;

    private News makeNews(Long id, String title) {
        News n = new News();
        n.setId(id);
        n.setTitle(title);
        n.setContent("Content");
        return n;
    }

    @Test
    @WithMockUser
    void getAll_authenticated_returns200() throws Exception {
        when(newsService.getAll()).thenReturn(List.of(makeNews(1L, "Hello")));

        mockMvc.perform(get("/api/news/get-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Hello"));
    }

    @Test
    void getAll_unauthenticated_returns401or403() throws Exception {
        mockMvc.perform(get("/api/news/get-all"))
                .andExpect(status().is(org.hamcrest.Matchers.anyOf(
                        org.hamcrest.Matchers.is(401),
                        org.hamcrest.Matchers.is(403))));
    }

    @Test
    @WithMockUser(roles = "TEACHER")
    void createNews_asTeacher_returns200() throws Exception {
        News news = makeNews(1L, "School Event");
        when(newsService.saveWithImage(any(), any(), isNull(), any())).thenReturn(news);

        mockMvc.perform(multipart("/api/news/new")
                        .param("title", "School Event")
                        .param("content", "Some content"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("School Event"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void createNews_asUser_returns403() throws Exception {
        mockMvc.perform(multipart("/api/news/new")
                        .param("title", "School Event")
                        .param("content", "Some content"))
                .andExpect(status().isForbidden());
    }

    @Test
    void createNews_unauthenticated_returns401or403() throws Exception {
        mockMvc.perform(multipart("/api/news/new")
                        .param("title", "School Event")
                        .param("content", "Some content"))
                .andExpect(status().is(org.hamcrest.Matchers.anyOf(
                        org.hamcrest.Matchers.is(401),
                        org.hamcrest.Matchers.is(403))));
    }
}
