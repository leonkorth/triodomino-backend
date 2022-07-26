package de.leonkorth.triodominobackend.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true,nullable = false)
    @NotBlank(message = "the name must not be blank")
    @Size(min = 3, max = 30, message = "please provide a name between 3 and 30 characters")
    private String name;


    @OneToMany(mappedBy = "playerEntity")
    private Set<GamePlayerEntity> gamePlayerEntities = new HashSet<>();

    public PlayerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity playerEntity = (PlayerEntity) o;
        return Objects.equals(id, playerEntity.id) && Objects.equals(name, playerEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
