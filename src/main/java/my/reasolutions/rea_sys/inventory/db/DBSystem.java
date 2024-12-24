package my.reasolutions.rea_sys.inventory.db;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DBSystem {
    private VisualInspection visualInspection;
    private VoltageIncomingFromTnB voltageIncomingFromTnB;
    private InsulationTest insulationTest;
    private List<RCCBTest> rccbTest;
}
