package my.reasolutions.rea_sys.inventory.db;

import jakarta.persistence.*;
import lombok.*;
import my.reasolutions.rea_sys.inventory.db.mcb.Mcb;
import my.reasolutions.rea_sys.inventory.db.rccb.RccbSize;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class VisualInspection {

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

    private int mainSwitchSize;
    private double mainSwitchSensitivity;
    // 2,3,4 pole
    private int totalPole;

    @OneToMany(mappedBy = "visualInspection")
    private List<RccbSize> rccBSize;

    @OneToMany(mappedBy = "visualInspection")
    private List<Mcb> mcb;

    // Total cable count in DB
    private int liveCount;
    private int neutralCount;
    private int earthCount;

    private String remarks;
}
