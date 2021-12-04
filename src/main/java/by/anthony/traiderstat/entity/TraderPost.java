package by.anthony.traiderstat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trader_posts")
@Data
@NoArgsConstructor
public class TraderPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_trader_fk")
    @ManyToOne
    @JoinColumn(table = "users", name = "id")
    private User trader;

    @Column(name = "id_game_fk")
    @ManyToOne
    @JoinColumn(table = "games", name = "id")
    private Game game;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
}