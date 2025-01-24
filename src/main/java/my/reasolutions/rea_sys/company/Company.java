package my.reasolutions.rea_sys.company;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import my.reasolutions.rea_sys.common.BaseEntity;
import my.reasolutions.rea_sys.user.User;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Builder
@Entity
public class Company extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "company_sequence"
    )
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;
    private String companyRegistration;

    private String streetOne;
    private String streetTwo;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}
