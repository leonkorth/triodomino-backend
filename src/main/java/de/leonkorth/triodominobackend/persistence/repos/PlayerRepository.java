package de.leonkorth.triodominobackend.persistence.repos;

import com.sun.xml.bind.v2.schemagen.episode.Klass;
import de.leonkorth.triodominobackend.persistence.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findFirstByName(String name);

}
