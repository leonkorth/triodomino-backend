package de.leonkorth.triodominobackend.persistence.repos;

import de.leonkorth.triodominobackend.persistence.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findFirstByName(String name);

}
