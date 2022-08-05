package de.leonkorth.triodominobackend.persistence.entities;

import de.leonkorth.triodominobackend.service.GameService;
import de.leonkorth.triodominobackend.service.PlayerService;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

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


    @Column(name = "placement")
    @Positive(message = "value must be positive")
    private int placement;


    @Column(name = "points")
    private int points;

   @Column(name = "draws")
   @PositiveOrZero
    private int draws;

    public GamePlayerEntityPK getId() {
        return id;
    }

    public void setId(GamePlayerEntityPK id) {
        this.id = id;
    }

    public GameEntity getGameEntity() {
        return gameEntity;
    }

    public void setGameEntity(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayerEntity that = (GamePlayerEntity) o;
        return placement == that.placement && points == that.points && draws == that.draws && Objects.equals(id, that.id) && Objects.equals(gameEntity, that.gameEntity) && Objects.equals(playerEntity, that.playerEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameEntity, playerEntity, placement, points, draws);
    }

    public GamePlayerEntity() {
    }

    public GamePlayerEntity(GamePlayerEntityPK id, GameEntity gameEntity, PlayerEntity playerEntity, int placement, int points, int draws) {
        this.id = id;
        this.gameEntity = gameEntity;
        this.playerEntity = playerEntity;
        this.placement = placement;
        this.points = points;
        this.draws = draws;
    }
}
