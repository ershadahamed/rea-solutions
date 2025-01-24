package my.reasolutions.rea_sys.inventory.earthing;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.Inventory;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class Earthing {

    @Id
    @SequenceGenerator(
            name = "earthing_sequence",
            sequenceName = "earthing_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "earthing_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne(mappedBy = "earthingSystem")
    private Inventory inventory;

    private int cableSize;
    private int totalCableTerminated;
    private double cableResistanceBefore;
    private double cableResistanceAfter;
    private double voltageLeakage;
    private boolean cableConnected;

    private String remarks;
}
