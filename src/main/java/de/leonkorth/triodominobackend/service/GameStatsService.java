package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.GamePlayerEntity;
import de.leonkorth.triodominobackend.persistence.entities.gameStat;
import de.leonkorth.triodominobackend.persistence.repos.GameRepository;
import de.leonkorth.triodominobackend.persistence.repos.GamePlayerRepository;
import de.leonkorth.triodominobackend.persistence.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.toIntExact;

@Service
public class GameStatsService {

    @Autowired
    GamePlayerRepository gamePlayerRepo;

    @Autowired
    GameRepository gameRepo;

    @Autowired
    PlayerRepository playerRepo;

    public gameStat getStatsForPlayer(Long playerId){

        List<GamePlayerEntity>  entities = new ArrayList<>(gamePlayerRepo.findAll())
                .stream()
                .filter(entity -> entity.getPlayerEntity().getId().equals(playerId))
                .toList();

        int totalGames = entities.size();

        int points = entities.stream().map(GamePlayerEntity::getPoints).reduce(0, Integer::sum);

        int draws = entities.stream().map(GamePlayerEntity::getDraws).reduce(0, Integer::sum);

        int victories = toIntExact(entities.stream().filter(entity -> entity.getPlacement() == 1).count());

        return new gameStat(playerId,totalGames,victories,points,draws);

    }

}