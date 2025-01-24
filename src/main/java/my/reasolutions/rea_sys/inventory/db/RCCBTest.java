package my.reasolutions.rea_sys.inventory.db;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.inventory.db.soket.Socket;
import my.reasolutions.rea_sys.inventory.db.wiring.Wiring;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class RCCBTest {

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

    @OneToMany(mappedBy = "rccbTest")
    private List<Socket> socket;

    @OneToMany(mappedBy = "rccbTest")
    private List<Wiring> wiring;

    private String remarks;
}
