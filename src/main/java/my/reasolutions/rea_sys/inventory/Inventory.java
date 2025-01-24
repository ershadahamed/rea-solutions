package my.reasolutions.rea_sys.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.address.Address;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.inventory.db.DBSystem;
import my.reasolutions.rea_sys.inventory.earthing.Earthing;
import my.reasolutions.rea_sys.inventory.tnb.MeterTNB;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Builder
@Entity
public class Inventory extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "inventory_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;
    private LocalDateTime inspectionDateTime;
    private String summary;
    private String suggestion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metertnb_id", referencedColumnName = "id", nullable = false)
    private MeterTNB meterTNB;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "earthing_id", referencedColumnName = "id", nullable = false)
    private Earthing earthingSystem;

    @OneToMany(mappedBy = "inventory")
    private List<DBSystem> dbSystem;

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;
}
