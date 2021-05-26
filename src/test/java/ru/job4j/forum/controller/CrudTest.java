package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class CrudTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenGetViewCreate() throws Exception {
        this.mockMvc.perform(
                get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("create"));
    }

    @Test
    @WithMockUser
    public void whenSavePost() throws Exception {
        Post post = mock(Post.class);
        mockMvc.perform(
                post("/create")
                        .sessionAttr("post", post)
                        .param("name", "one")
                        .param("description", "one"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser
    public void whenGetViewEdit() throws Exception {
        mockMvc.perform(
                get("/edit")
                        .param("id", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void whenEditPost() throws Exception {
        Post post = mock(Post.class);
        mockMvc.perform(
                post("/edit")
                        .sessionAttr("post", post)
                        .param("name", "two")
                        .param("description", "two"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser
    public void whenDeleteById() throws Exception {
        mockMvc.perform(
                get("/delete")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }
}