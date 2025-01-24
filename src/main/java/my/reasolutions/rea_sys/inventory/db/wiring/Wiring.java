package my.reasolutions.rea_sys.inventory.db.wiring;

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
public class Wiring {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rccb_test_id", nullable = false)
    private RCCBTest rccbTest;

    @Enumerated(EnumType.STRING)
    private WiringType wiringType;
    private int point;
    private String remarks;
}
