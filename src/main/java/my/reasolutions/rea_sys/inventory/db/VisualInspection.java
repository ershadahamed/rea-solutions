package my.reasolutions.rea_sys.inventory.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VisualInspection {
    private int mainSwitchSize;
    private double mainSwitchSensitivity;


    private int liveCount;
    private int neutralCount;
    private int earthCount;
}
