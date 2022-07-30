package de.leonkorth.triodominobackend.web;


import de.leonkorth.triodominobackend.persistence.entities.Gender;
import de.leonkorth.triodominobackend.persistence.entities.Player;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PlayerControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @MockBean
 private PlayerService playerService;

 @Test
 @DisplayName("should return all players in json format")
 void findAllPlayers() throws Exception{
     var players = List.of(
             new Player(1L,"Leon", Gender.FEMALE),
             new Player(2L,"Leon2", Gender.MALE)
     );

     doReturn(players).when(playerService).findAll();

     mockMvc.perform(get("/api/v1/players"))
             // then
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.size()").value(2))
             .andExpect(jsonPath("$[0].id").value(1L))
             .andExpect(jsonPath("$[0].name").value("Leon"))
             .andExpect(jsonPath("$[0].gender").value("FEMALE"))
             .andExpect(jsonPath("$[1].id").value(2L))
             .andExpect(jsonPath("$[1].name").value("Leon2"))
             .andExpect(jsonPath("$[1].gender").value("MALE"));

 }
 @Test
 @DisplayName("should validate create ingredient request with invalid name")
 void createInvalidPlayer() throws Exception{
     String player = "{\"name\": \"xx\",\"gender\": \"FEMALE\"}";

     mockMvc.perform(
             post("/api/v1/players")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(player)
                     .characterEncoding("utf-8")
     )
     .andExpect(status().isBadRequest());
 }

    @Test
    @DisplayName("should validate create ingredient request with invalid gender (lowercase)")
    void createInvalidPlayer2() throws Exception{
        String player = "{\"name\": \"xxxx\",\"gender\": \"female\"}";

        mockMvc.perform(
                        post("/api/v1/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(player)
                                .characterEncoding("utf-8")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should validate create ingredient request with valid gender")
    void createInvalidPlayer3() throws Exception{
        String player = "{\"name\": \"xxxx\",\"gender\": \"FEMALE\"}";

        mockMvc.perform(
                        post("/api/v1/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(player)
                                .characterEncoding("utf-8")
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should validate create ingredient request with invalid gender (typo)")
    void createInvalidPlayer4() throws Exception{
        String player = "{\"name\": \"xxxx\",\"gender\": \"mele\"}";

        mockMvc.perform(
                        post("/api/v1/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(player)
                                .characterEncoding("utf-8")
                )
                .andExpect(status().isBadRequest());
    }




}
