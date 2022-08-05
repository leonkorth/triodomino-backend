package de.leonkorth.triodominobackend.web.controller;

import de.leonkorth.triodominobackend.persistence.entities.GamePlayerEntity;
import de.leonkorth.triodominobackend.service.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GamePlayerController {

    @Autowired(required = false)
    GamePlayerService service;

    @GetMapping(path = "/api/v1/gamePlayers")
    public ResponseEntity<List<GamePlayerEntity>> getAllGamePlayers() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(path = "/api/v1/gamePlayers")
    public GamePlayerEntity createGamePlayer(@Valid @RequestBody GamePlayerEntity gamePlayer){
        return service.createGamePlayer(gamePlayer);
    }

}
