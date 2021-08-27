package com.meli.obtenerdiploma.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.unit.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        List<SubjectDTO> subjectsList = new ArrayList<>();
        subjectsList.add(new SubjectDTO("Matemática", 9.0));
        subjectsList.add(new SubjectDTO("Física", 7.0));
        subjectsList.add(new SubjectDTO("Química", 6.0));
        StudentDTO stu = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, subjectsList);

        TestUtilsGenerator.appendNewStudent(stu);
    }

    @Test
    public void studentNotFoundCantGetDiplomaFromStudent() throws Exception {
            this.mockMvc.perform(get("/analyzeScores/{studentId}", "10"))
            .andDo(print())
            .andExpect(status().isNotFound())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                    .andExpect(jsonPath("$.description").value("El alumno con Id 10 no se encuetra registrado."));
    }

    @Test
    public void getDiplimaFromStudent() throws Exception {
        List<SubjectDTO> subjectsList = new ArrayList<>();
        subjectsList.add(new SubjectDTO("Matemática", 9.0));
        subjectsList.add(new SubjectDTO("Física", 7.0));
        subjectsList.add(new SubjectDTO("Química", 6.0));
        StudentDTO stu = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, subjectsList);

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = objectWriter.writeValueAsString(stu);

        MvcResult mvcResult =
                this.mockMvc.perform(get("/analyzeScores/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(payloadJson, mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }
}
