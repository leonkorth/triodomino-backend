package de.leonkorth.triodominobackend.persistence.repos;

import de.leonkorth.triodominobackend.persistence.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <GameEntity, Long> {

}
