package com.gmail.andreyzarazka.publicbid.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.andreyzarazka.publicbid.controler.responce.Error;
import com.gmail.andreyzarazka.publicbid.controler.responce.Success;
import com.gmail.andreyzarazka.publicbid.service.ContractsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OpenProcurementController.class)
public class OpenProcurementControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContractsService service;

    @Test
    public void whenLoadedDataFromRESTServerToDatabase() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        given(this.service.uploadFromRESTIntoDatabase()).willReturn(true);
        this.mvc.perform(
                post("/upload").contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(mapper.writeValueAsString(new Success("The data is loaded into the database")))
        );
    }

    @Test
    public void whenDataNotLoadedIntoDB() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        given(this.service.uploadFromRESTIntoDatabase()).willReturn(false);
        this.mvc.perform(
                post("/upload").contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(mapper.writeValueAsString(new Error("No data to load into the database")))
        );
    }
}