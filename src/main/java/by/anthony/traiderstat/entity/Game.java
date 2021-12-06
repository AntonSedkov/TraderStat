package by.anthony.traiderstat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Game name is required")
    @Max(value = 64, message = "Game name must be less than 64 characters")
    private String name;

    @JsonIgnoreProperties("games")
    @ManyToMany(mappedBy = "games")
    private List<User> traders;
}