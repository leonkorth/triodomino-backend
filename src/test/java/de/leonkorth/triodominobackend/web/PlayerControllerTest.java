package de.leonkorth.triodominobackend.web;


import de.leonkorth.triodominobackend.persistence.entities.Gender;
import de.leonkorth.triodominobackend.persistence.entities.PlayerEntity;
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
             new PlayerEntity(1L,"Leon"),
             new PlayerEntity(2L,"Leon2")
     );

     doReturn(players).when(playerService).findAll();

     mockMvc.perform(get("/api/v1/players"))
             // then
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.size()").value(2))
             .andExpect(jsonPath("$[0].id").value(1L))
             .andExpect(jsonPath("$[0].name").value("Leon"))
             .andExpect(jsonPath("$[1].id").value(2L))
             .andExpect(jsonPath("$[1].name").value("Leon2"));

 }


 @Test
 @DisplayName("should find player by name ")
 void findPlayerByName1() throws Exception{
     var player = new PlayerEntity(1L,"Leon");

     doReturn(player).when(playerService).findByName("Leon");

     mockMvc.perform(get("/api/v1/players?name=Leon"))
             .andExpect(status().isOk());

 }

    @Test
    @DisplayName("should not find player by name ")
    void findPlayerByName2() throws Exception{

        doReturn(null).when(playerService).findByName("Leon");

        mockMvc.perform(get("/api/v1/players?name=Leon"))
                .andExpect(status().isNotFound());

    }



 @Test
 @DisplayName("should validate create ingredient request with invalid name")
 void createInvalidPlayer() throws Exception{
     String player = "{\"name\": \"xx\"}";

     mockMvc.perform(
             post("/api/v1/players")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(player)
                     .characterEncoding("utf-8")
     )
     .andExpect(status().isBadRequest());
 }




}
