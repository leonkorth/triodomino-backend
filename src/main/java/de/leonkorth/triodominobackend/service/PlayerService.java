package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.Player;
import de.leonkorth.triodominobackend.persistence.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public List<Player> findAll() {return repository.findAll();}

    public Player createPlayer(Player player){
        return repository.save(player);
    }

    public Player findByName(String name){
        var playerEntity = repository.findFirstByName(name);
        return playerEntity.orElse(null);
    }
}
