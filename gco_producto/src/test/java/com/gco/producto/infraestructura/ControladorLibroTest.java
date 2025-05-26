package com.gco.producto.infraestructura;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.gco.producto.aplicacion.comando.*;
import com.gco.producto.testdatabuilder.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorLibroTest {

    public static final String ISBN_LIBRO_PD1023 = "123";
    public static final String ISBN_LIBRO_1234 = "1";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getLibroPorIsbn() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/producto/{id}", ISBN_LIBRO_PD1023)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(ISBN_LIBRO_PD1023));
    }

    @Test
    public void crearLibro() throws Exception {
        ComandoProducto comandoLibro = new LibroTestDataBuilder().buildComando();
        mvc.perform(MockMvcRequestBuilders
                .post("/producto")
                .content(objectMapper.writeValueAsString(comandoLibro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                .get("/producto/byId/{isbn}", ISBN_LIBRO_1234)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(ISBN_LIBRO_1234));
    }
}
