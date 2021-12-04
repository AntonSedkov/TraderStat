package by.anthony.traiderstat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@ToString(exclude = {"password", "role"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 64, message = "First name must be at least 3 characters long, but less than 64 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 64, message = "Last name must be at least 3 characters long, but less than 64 characters")
    private String lastName;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,64}$", message = "Password must contain at least one lowercase character, " +
            "one uppercase character, one digit, and a length between 6 to 64")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(unique = true, length = 64)
    @NotBlank(message = "Email is required")
    @Size(min = 4, max = 64, message = "Email must be at least 4 characters, but less than 64 characters")
    @Email(message = "Wrong email format")
    //todo "Unique check?"
    private String email;

    @Column(name = "create_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = true, updatable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "trader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //todo "Does it need ?"
    private List<TraderPost> posts;

    @PrePersist
    public void onCreate() {
        this.setCreatedAt(LocalDateTime.now());
    }

}