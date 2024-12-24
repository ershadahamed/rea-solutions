package my.reasolutions.rea_sys.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.address.Address;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.customer.Customer;
import my.reasolutions.rea_sys.inventory.db.DBSystem;
import my.reasolutions.rea_sys.inventory.earthing.Earthing;
import my.reasolutions.rea_sys.inventory.tnb.MeterTNB;

import java.time.LocalDateTime;

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

    @Embedded
    private MeterTNB meterTNB;

    @Embedded
    private Earthing earthingSystem;

    @Embedded
    private DBSystem dbSystem;

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;
}
