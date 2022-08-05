package de.leonkorth.triodominobackend.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

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
}
