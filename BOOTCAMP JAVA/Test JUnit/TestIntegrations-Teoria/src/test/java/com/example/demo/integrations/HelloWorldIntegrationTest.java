package com.example.demo.integrations;

import com.example.demo.dtos.HelloDTO;
import com.example.demo.dtos.StudentTestDTO;
import com.example.demo.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldIntegrationTest{

    @Autowired
    private MockMvc mockMvc;

    /* TODO: Test 2/6*/

    @Test
    @DisplayName("Test Validar Hello World")
    public void testHellowWorldOutput() throws Exception{
        MvcResult  mvcResult =
                this.mockMvc.perform(get("/sayHello"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Hello World!"))
                    .andReturn();

            Assertions.assertEquals("application/json" , mvcResult.getResponse().getContentType());
    }

    /* TODO: Test 3/6*/
    @Test
    @DisplayName("Test Validar Path V Nombre")
    public void testHellowWorldPathVarible() throws Exception{
                this.mockMvc.perform(get("/sayHello/{name}", "George"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.id").value(1L))
                        .andExpect(jsonPath("$.message").value("Hello George!"));

    }


    /* TODO: Test 4/6*/
    @Test
    @DisplayName("Test Validar Parametro Nombre")
    public void testHellowWorldPathV() throws Exception{
                this.mockMvc.perform(get("/sayHelloWithParam")
                        .param("name", "George"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.id").value(1L))
                        .andExpect(jsonPath("$.message").value("Hello George!"));
    }

    /* TODO: Test 4/6*/
    @Test
    @DisplayName("Test Validar Multi Parametros")
    public void testHellowWorldMultiParam() throws Exception{

        MultiValueMap myMap = new LinkedMultiValueMap();
        myMap.add("id", "1");
        myMap.add("name", "George");

                this.mockMvc.perform(get("/sayHelloWithParam")
                        .params(myMap))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.id").value(1L))
                        .andExpect(jsonPath("$.message").value("Hello George!"));

    }

    /* TODO: Test 5/6*/
    @Test
    @DisplayName("Test Validar Post Atributo")
    public void testHellowWorlPostAtr() throws Exception{
        HelloDTO payloadDTO = new HelloDTO(1L, "George");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJSON = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/sayHelloPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello George by POST!"));
    }


    @Test
    @DisplayName("Test Validar Post Objeto")
    public void testHellowWorlPostObj() throws Exception{
        /* TODO: OBJETO QUE SE ENVIA EN EL PAYLOAD*/
        HelloDTO payloadDTO = new HelloDTO(1L, "George");

        /* TODO: OBJETO QUE SE COMPARAR EN EL RESPONSE*/
        StudentTestDTO responseDTO = new StudentTestDTO(1L, "Hello George by POST!");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult  mvcResult =
                this.mockMvc.perform(post("/sayHelloPost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }


}
