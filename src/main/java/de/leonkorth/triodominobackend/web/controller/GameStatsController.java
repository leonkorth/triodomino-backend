package de.leonkorth.triodominobackend.web.controller;

import de.leonkorth.triodominobackend.persistence.entities.GameStat;
import de.leonkorth.triodominobackend.service.GameStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameStatsController {

    @Autowired(required = false)
    GameStatsService service;

    @GetMapping(path = "/api/v1/stats/players/{id}")
    public ResponseEntity<GameStat> getStatsForPlayer(@PathVariable String id){

        var stats = service.getStatsForPlayer(Long.parseLong(id));

        return stats != null ? ResponseEntity.ok(stats) : ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/api/v1/stats/players")
    public ResponseEntity<List<GameStat>> getStatsForAllPLayers(){

        var stats = service.getStatsForAllPlayers();

        return stats != null ? ResponseEntity.ok(stats) : ResponseEntity.notFound().build();

    }
}
