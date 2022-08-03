package de.leonkorth.triodominobackend.web;

import de.leonkorth.triodominobackend.persistence.entities.GameEntity;
import de.leonkorth.triodominobackend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired(required = false)
    GameService service;

    @PostMapping(path = "/api/v1/games")
    public GameEntity createGame(@Valid @RequestBody GameEntity gameEntity){return service.createGame(gameEntity);}

    @GetMapping(path = "/api/v1/games")
    public ResponseEntity<List<GameEntity>> getGames() {return ResponseEntity.ok(service.findAll());}
}
