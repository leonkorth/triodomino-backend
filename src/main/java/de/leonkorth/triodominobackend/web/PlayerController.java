package de.leonkorth.triodominobackend.web;


import de.leonkorth.triodominobackend.persistence.Player;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;

    @PostMapping(path = "/api/v1/players")
    public Player createPlayer(@RequestBody Player player){
        return service.createPlayer(player);
    }

    @GetMapping(path = "/api/v1/players")
    public ResponseEntity<List<Player>> getIngredients(){
        return ResponseEntity.ok(service.findAll());
    }
}