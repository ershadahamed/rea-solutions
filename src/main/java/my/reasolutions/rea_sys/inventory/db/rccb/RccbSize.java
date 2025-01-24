package my.reasolutions.rea_sys.inventory.db.rccb;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.db.CircuitType;
import my.reasolutions.rea_sys.inventory.db.VisualInspection;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class RccbSize {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visualInspection_id", nullable = false)
    private VisualInspection visualInspection;

    @Enumerated(EnumType.STRING)
    private CircuitType circuitType;

    private int rccbSize;
    private double rccbSensitivity;
    private int totalPole;
    private String remark;
}
