package de.leonkorth.triodominobackend.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamePlayerEntityPK implements Serializable {

    @Column(name ="GAME_ID")
    private Long gameId;

    @Column(name = "PLAYER_ID")
    private Long playerId;

    public GamePlayerEntityPK(Long gameId, Long playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }


    public GamePlayerEntityPK() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayerEntityPK that = (GamePlayerEntityPK) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
