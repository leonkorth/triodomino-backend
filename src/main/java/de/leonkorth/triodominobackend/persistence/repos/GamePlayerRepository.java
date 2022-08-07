package de.leonkorth.triodominobackend.persistence.repos;

import de.leonkorth.triodominobackend.persistence.entities.GamePlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayerEntity, Long> {



}
