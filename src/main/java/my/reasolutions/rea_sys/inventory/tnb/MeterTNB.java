package my.reasolutions.rea_sys.inventory.tnb;

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
public class MeterTNB {

    @Id
    @SequenceGenerator(
            name = "metertnb_sequence",
            sequenceName = "metertnb_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "metertnb_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Embedded
    private Cables cables;

    @OneToOne(mappedBy = "meterTNB")
    private Inventory inventory;

    private boolean cutOutCondition;
    private boolean neutralLinkAndCableCondition;
    private String remark;
}
