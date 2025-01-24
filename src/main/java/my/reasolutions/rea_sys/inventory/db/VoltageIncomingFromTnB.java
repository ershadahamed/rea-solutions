package my.reasolutions.rea_sys.inventory.db;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.tnb.Phase;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class VoltageIncomingFromTnB {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    @Column(name = "dbsystem_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "dbsystem_id")
    @MapsId
    private DBSystem dbSystem;

    @Enumerated(EnumType.STRING)
    private Phase phase;

    // This is mainly for single phase
    private double lN;
    private double lE;

    private double nE;

    private double rY;
    private double rB;
    private double bY;

    private double rN;
    private double bN;
    private double yN;

    private double rE;
    private double bE;
    private double yE;

    private String remark;
}
