package my.reasolutions.rea_sys.inventory.db;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.inventory.Inventory;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class DBSystem extends BaseEntity {

    @Id
    @SequenceGenerator(
            name = "dbsystem_sequence",
            sequenceName = "dbsystem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "dbsystem_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventoryId", nullable = false)
    private Inventory inventory;

    @OneToOne(mappedBy = "dbSystem", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private VisualInspection visualInspection;

    @OneToOne(mappedBy = "dbSystem", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private VoltageIncomingFromTnB voltageIncomingFromTnB;

    @OneToOne(mappedBy = "dbSystem", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private InsulationTest insulationTest;

    @OneToOne(mappedBy = "dbSystem", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private RCCBTest rccbTest;

    private String floor;

    @Enumerated(EnumType.STRING)
    private DbType dbType;
}
