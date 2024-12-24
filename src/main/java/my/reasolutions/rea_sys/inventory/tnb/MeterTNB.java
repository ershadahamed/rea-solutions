package my.reasolutions.rea_sys.inventory.tnb;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MeterTNB {
    @Enumerated(EnumType.STRING)
    private Phase phase;
    private Cables cables;
    private boolean cutOutCondition;
    private boolean neutralLinkAndCableCondition;
    private String remark;
}
