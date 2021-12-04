package by.anthony.traiderstat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Comment message is required")
    private String message;

    @Min(value = 0, message = "Email must be greater than 0")
    @Max(value = 100, message = "Email must be not greater than 100")
    private int rating;

    @NotBlank(message = "Reviewer name is required")
    @Size(min = 3, max = 64, message = "Reviewer name must be at least 3 characters long, but less than 64 characters")
    private String reviewer;

    @Column(name = "id_post_fk")
    @ManyToOne
    @JoinColumn(table = "trader_posts", name = "id")
    private TraderPost post;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    private boolean approved;

    @PrePersist
    public void onCreate() {
        this.setCreatedAt(LocalDateTime.now());
        this.setModifiedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setModifiedAt(LocalDateTime.now());
    }

  /*

    id_post_fk varchar(64) not null,
    created_at timestamp   not null,
    approved   boolean     not null default false,
    foreign key (id_post_fk) references trader_posts (id)*/

}
