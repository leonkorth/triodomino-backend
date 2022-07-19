package de.leonkorth.triodominobackend.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
@Entity(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true,nullable = false)
    @NotBlank(message = "the name must not be blank")
    @Size(min = 3, max = 30, message = "please provide a name between 3 and 30 characters")
    private String name;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Gender gender;

    public Player(Long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Player() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && gender == player.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
