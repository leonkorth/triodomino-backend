package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.*;
import de.leonkorth.triodominobackend.persistence.repos.GamePlayerRepository;
import de.leonkorth.triodominobackend.persistence.repos.PlayerRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith({MockitoExtension.class})
public class GameStatsServiceTest implements WithAssertions {

    @Mock
    GamePlayerRepository gamePlayerRepo;

    @Mock
    PlayerRepository playerRepo;

    @InjectMocks
    GameStatsService service;

    @Test
    @DisplayName("should return the correct player stats for one player")
    void testGetStatsForPlayer(){

        PlayerEntity player1 = new PlayerEntity(1L,"Leon", Gender.MALE);
        PlayerEntity player2 = new PlayerEntity(2L,"Maxi", Gender.FEMALE);

        GameEntity game1 = new GameEntity(10L, LocalDate.of(2022,12,1));
        GameEntity game2 = new GameEntity(20L, LocalDate.of(2021,1,2));

        var entities = List.of(
                new GamePlayerEntity(new GamePlayerEntityPK(10L,1L),game1,player1,1,100,0),
                new GamePlayerEntity(new GamePlayerEntityPK(10L,2L),game1,player2,2,50,2),
                new GamePlayerEntity(new GamePlayerEntityPK(20L,1L),game2,player1,2,30,5),
                new GamePlayerEntity(new GamePlayerEntityPK(20L,2L),game2,player2,1,200,0)
        );

        doReturn(entities).when(gamePlayerRepo).findAll();
        doReturn(Optional.of(player1)).when(playerRepo).findById(1L);
        doReturn(Optional.of(player2)).when(playerRepo).findById(2L);

        GameStat expected1 = new GameStat(1L,"Leon",2,1,130,5);
        GameStat actual1 = service.getStatsForPlayer(1L);

        GameStat expected2 = new GameStat(2L,"Maxi",2,1,250,2);
        GameStat actual2 = service.getStatsForPlayer(2L);

        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);






    }



}
