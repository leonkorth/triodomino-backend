package de.leonkorth.triodominobackend.web;

import de.leonkorth.triodominobackend.persistence.entities.GameStat;
import de.leonkorth.triodominobackend.service.GameStatsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest
public class GameStatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameStatsService service;

    @Test
    @DisplayName("should validate bad request")
    void getStatsForNotExistingPlayer() throws Exception{

        doReturn(null).when(service).getStatsForPlayer(1L);

        mockMvc.perform(get("/api/v1/stats/players/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should validate good request")
    void getStatsForExistingPlayer() throws Exception{

        doReturn(new GameStat(1L,"Leon",3,1,100,1)).when(service).getStatsForPlayer(1L);

        mockMvc.perform(get("/api/v1/stats/players/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Leon"))
                .andExpect(jsonPath("$.playerId").value(1))
                .andExpect(jsonPath("$.gamesCount").value(3))
                .andExpect(jsonPath("$.victories").value(1))
                .andExpect(jsonPath("$.totalPoints").value(100))
                .andExpect(jsonPath("$.draws").value(1));
    }

}
