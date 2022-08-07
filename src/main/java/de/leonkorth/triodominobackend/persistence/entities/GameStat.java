package de.leonkorth.triodominobackend.persistence.entities;

public record GameStat(Long playerId, String name, int gamesCount, int victories, int totalPoints, int draws) {
}
