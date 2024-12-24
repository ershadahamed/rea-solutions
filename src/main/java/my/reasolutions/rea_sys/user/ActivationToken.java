package my.reasolutions.rea_sys.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
public class ActivationToken {

    @Id
    @SequenceGenerator(
            name = "activation_token_sequence",
            sequenceName = "activation_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "activation_token_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    private String token;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
