package de.leonkorth.triodominobackend.persistence.repos;

import de.leonkorth.triodominobackend.persistence.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
