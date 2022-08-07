package de.leonkorth.triodominobackend.persistence.entities;

public record gameStat(Long playerId, int gamesCount, int victories, int totalPoints, int draws) {
}
