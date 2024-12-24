package my.reasolutions.rea_sys.address;

import jakarta.persistence.*;
import lombok.*;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.customer.Customer;
import my.reasolutions.rea_sys.inventory.Inventory;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Address extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    private String streetOne;
    private String streetTwo;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;
    private String zip;
    private String houseType;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "address")
    private List<Inventory> inventory;
}
