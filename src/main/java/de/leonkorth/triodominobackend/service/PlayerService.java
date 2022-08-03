package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.PlayerEntity;
import de.leonkorth.triodominobackend.persistence.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public List<PlayerEntity> findAll() {return repository.findAll();}

    public PlayerEntity createPlayer(PlayerEntity playerEntity){
        return repository.save(playerEntity);
    }

    public PlayerEntity findByName(String name){
        var playerEntity = repository.findFirstByName(name);
        return playerEntity.orElse(null);
    }
}
