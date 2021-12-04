package by.anthony.traiderstat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class TraderPostId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_trader_fk")
    @JsonIgnore
    private User trader;

    @ManyToOne
    @JoinColumn(name = "id_game_fk")
    @JsonIgnore
    private Game game;
}