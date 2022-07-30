package de.leonkorth.triodominobackend.web;

import de.leonkorth.triodominobackend.persistence.entities.Game;
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
    public Game createGame(@Valid @RequestBody Game game){return service.createGame(game);}

    @GetMapping(path = "/api/v1/games")
    public ResponseEntity<List<Game>> getGames() {return ResponseEntity.ok(service.findAll());}
}
