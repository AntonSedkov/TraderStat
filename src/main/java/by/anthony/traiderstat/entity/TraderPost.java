package by.anthony.traiderstat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trader_posts")
@Data
@NoArgsConstructor
public class TraderPost {

    @EmbeddedId
    private TraderPostId traderPostId;
}
