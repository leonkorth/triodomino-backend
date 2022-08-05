package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.GamePlayerEntity;
import de.leonkorth.triodominobackend.persistence.entities.GamePlayerEntityPK;
import de.leonkorth.triodominobackend.persistence.repos.GameServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamePlayerService {

    @Autowired
    GameServiceRepository repository;

    public List<GamePlayerEntity> findAll() {return repository.findAll();}

    public GamePlayerEntity createGamePlayer(GamePlayerEntity gamePlayer) {return repository.save(gamePlayer);}

}
