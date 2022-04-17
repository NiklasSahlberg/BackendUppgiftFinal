package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.repositories.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemRepository mockRepository;

    @BeforeEach
    public void init()
    {

        Items i1 = new Items();
        Items i2 = new Items();
        Items i3 = new Items();
        i1.setName("kyl");
        i1.setId(1L);
        i2.setName("potatis");
        i2.setId(2L);
        i3.setName("tvättmedel");
        i3.setId(3L);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(i1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(i1, i2, i3));


    }

    @Test
    void addItem() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/items/add?name=ost").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo("Varan ost sparad")));
    }

    @Test
    void allItems() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/items/all").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json("[{\"id\":1,\"name\":\"kyl\"}," +
                "{\"id\":2,\"name\":\"potatis\"},"+
                "{\"id\":3,\"name\":\"tvättmedel\"}]"));
    }

    @Test
    void itemById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/items/itemById?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"kyl\",\"id\":1}"));
    }

    @Test
    void buyItem() {
    }
}