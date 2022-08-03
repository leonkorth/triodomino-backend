package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.GameEntity;
import de.leonkorth.triodominobackend.persistence.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public List<GameEntity> findAll() {return repository.findAll();}

    public GameEntity createGame(GameEntity gameEntity) {return repository.save(gameEntity);}

}
