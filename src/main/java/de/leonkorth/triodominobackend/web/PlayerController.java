package de.leonkorth.triodominobackend.web;


import de.leonkorth.triodominobackend.persistence.entities.PlayerEntity;
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
    public PlayerEntity createPlayer(@Valid @RequestBody PlayerEntity playerEntity){
        return service.createPlayer(playerEntity);
    }

    @GetMapping(path = "/api/v1/players")
    public ResponseEntity<List<PlayerEntity>> getIngredients(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/api/v1/players", params = "name")
    public ResponseEntity<PlayerEntity> getPlayerByName(@RequestParam String name){
        PlayerEntity playerEntity = service.findByName(name);
        return playerEntity != null ? ResponseEntity.ok(playerEntity) : ResponseEntity.notFound().build();
    }
}
