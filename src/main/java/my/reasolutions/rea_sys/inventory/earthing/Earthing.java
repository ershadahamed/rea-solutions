package my.reasolutions.rea_sys.inventory.earthing;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Earthing {
    private int cableSize;
    private int totalCableTerminated;
    private double cableResistanceBefore;
    private double cableResistanceAfter;
    private double voltageLeakage;
    private boolean cableConnected;
}
