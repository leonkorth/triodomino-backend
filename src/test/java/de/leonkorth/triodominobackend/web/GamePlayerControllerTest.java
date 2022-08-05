package de.leonkorth.triodominobackend.web;

import de.leonkorth.triodominobackend.persistence.entities.*;
import de.leonkorth.triodominobackend.service.GamePlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GamePlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GamePlayerService service;

    @Test
    @DisplayName("should return all game players in json format")
    void findAllPlayer() throws Exception{

        GameEntity game = new GameEntity(1L, LocalDate.of(2022,3,1));
        PlayerEntity player = new PlayerEntity(1L,"Leon", Gender.MALE);

        var gamePlayerEntities = List.of(
                new GamePlayerEntity(new GamePlayerEntityPK(1L,1L),game,player,1,100,3)
        );

        doReturn(gamePlayerEntities).when(service).findAll();

        mockMvc.perform(get("/api/v1/gamePlayers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").isEmpty())
                .andExpect(jsonPath("$[0].gameEntity.id").value(1))
                .andExpect(jsonPath("$[0].gameEntity.date").value("01-03-2022"))
                .andExpect(jsonPath("$[0].playerEntity.id").value(1))
                .andExpect(jsonPath("$[0].playerEntity.name").value("Leon"))
                .andExpect(jsonPath("$[0].playerEntity.gender").value("MALE"))
                .andExpect(jsonPath("$[0].placement").value(1))
                .andExpect(jsonPath("$[0].draws").value(3))
                .andExpect(jsonPath("$[0].points").value(100));
    }




}
