package de.leonkorth.triodominobackend.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @FutureOrPresent(message = "please provide a date in the future or present")
    private LocalDate date;

    @OneToMany(mappedBy = "gameEntity")
    private Set<GamePlayerEntity> gamePlayerEntities = new HashSet<>();

    public GameEntity(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public GameEntity() {
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity gameEntity = (GameEntity) o;
        return Objects.equals(id, gameEntity.id) && Objects.equals(date, gameEntity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
