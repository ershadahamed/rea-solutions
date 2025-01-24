package my.reasolutions.rea_sys.inventory.db.soket;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.db.RCCBTest;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class Socket {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    private SocketType socketType;
    private int point;
    private int circuit;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "rccb_test_id", nullable = false)
    private RCCBTest rccbTest;
}
