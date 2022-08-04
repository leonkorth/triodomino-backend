package de.leonkorth.triodominobackend.persistence.entities;

import de.leonkorth.triodominobackend.service.GameService;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity(name = "gamePlayer")
public class GamePlayerEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    private GameEntity gameEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private PlayerEntity playerEntity;


    private int placement;
    private int points;
    private int draws;


}
