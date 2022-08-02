package de.leonkorth.triodominobackend.web;


import de.leonkorth.triodominobackend.persistence.entities.Player;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired(required = false)
    PlayerService service;

    @PostMapping(path = "/api/v1/players")
    public Player createPlayer(@Valid @RequestBody Player player){
        return service.createPlayer(player);
    }

    @GetMapping(path = "/api/v1/players")
    public ResponseEntity<List<Player>> getIngredients(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/api/v1/players", params = "name")
    public ResponseEntity<Player> getPlayerByName(@RequestParam String name){
        Player player = service.findByName(name);
        return player != null ? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }
}
