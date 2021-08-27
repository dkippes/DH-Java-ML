package com.meli.obtenerdiploma.integrations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    private MockMvc mockMvc;

    @Test
    @Disabled
    public void studentNotBodyInRequest() throws Exception {
        this.mockMvc.perform(post("/student/registerStudent"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
