package my.reasolutions.rea_sys.inventory.tnb;

import lombok.Getter;

@Getter
public enum Phase {
    SINGLE_PHASE("Single Phase"),
    THREE_PHASE("Three Phase")
    ;

    private final String name;
    Phase(String name) {
        this.name = name;
    }
}
