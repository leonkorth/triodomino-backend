package de.leonkorth.triodominobackend.web;

import de.leonkorth.triodominobackend.persistence.entities.GameEntity;
import de.leonkorth.triodominobackend.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @MockBean
   private GameService gameService;

    @Test
    @DisplayName("should return all games in json format")
    void findAllGames() throws Exception {
        var games = List.of(
                new GameEntity(1L, LocalDate.of(2023,1, 1)),
                new GameEntity( 2L, LocalDate.of(2022,2,2))
        );

        doReturn(games).when(gameService).findAll();

        mockMvc.perform(get("/api/v1/games")).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].date").value("01-01-2023"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].date").value("02-02-2022"));
    }

    @Test
    @DisplayName("should validate create game request with invalid date")
    void createInvalidGame1() throws Exception{
        String game = "{\"date\": \"12-11-202\"}";

        mockMvc.perform(
                post("/api/v1/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(game)
                        .characterEncoding("utf-8")
        )
        .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should validate create game request with date in the past")
    void createInvalidGame2() throws Exception{
        String game = "{\"date\": \"12-11-2019\"}";

        mockMvc.perform(
                        post("/api/v1/games")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(game)
                                .characterEncoding("utf-8")
                )
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("should validate create game request with date in the present or future")
    void createInvalidGame3() throws Exception{
        String game = "{\"date\": \"12-11-2029\"}";

        mockMvc.perform(
                        post("/api/v1/games")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(game)
                                .characterEncoding("utf-8")
                )
                .andExpect(status().isOk());

    }

}
