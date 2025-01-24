package my.reasolutions.rea_sys.customer;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.address.Address;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.user.User;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "customer")
    private List<Address> address;

    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
