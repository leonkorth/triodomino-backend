package de.leonkorth.triodominobackend.service;

import de.leonkorth.triodominobackend.persistence.entities.Game;
import de.leonkorth.triodominobackend.persistence.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public List<Game> findAll() {return repository.findAll();}

    public Game createGame(Game game) {return repository.save(game);}

}
