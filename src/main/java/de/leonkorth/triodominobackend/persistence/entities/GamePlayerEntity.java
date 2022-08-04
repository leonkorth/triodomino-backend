package de.leonkorth.triodominobackend.persistence.entities;

import de.leonkorth.triodominobackend.service.GameService;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity(name = "gamePlayer")
public class GamePlayerEntity {

    @EmbeddedId
    private GamePlayerEntityPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("gameId")
    @JoinColumn(name = "GAME_ID")
    private GameEntity gameEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @JoinColumn(name = "PLAYER_ID")
    private PlayerEntity playerEntity;


    private int placement;
    private int points;
    private int draws;


}
