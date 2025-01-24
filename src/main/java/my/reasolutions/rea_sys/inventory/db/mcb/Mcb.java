package my.reasolutions.rea_sys.inventory.db.mcb;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.db.CircuitType;
import my.reasolutions.rea_sys.inventory.db.McbType;
import my.reasolutions.rea_sys.inventory.db.PhaseColor;
import my.reasolutions.rea_sys.inventory.db.VisualInspection;
import my.reasolutions.rea_sys.inventory.tnb.Phase;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class Mcb {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visualInspection_id", nullable = false)
    private VisualInspection visualInspection;

    @Enumerated(EnumType.STRING)
    private Phase phase;
    @Enumerated(EnumType.STRING)
    private PhaseColor phaseColor;
    @Enumerated(EnumType.STRING)
    private CircuitType circuitType;
    @Enumerated(EnumType.STRING)
    private McbType mcbType;

    private double cableSize;
    private String remark;
    private int totalCable;
}
