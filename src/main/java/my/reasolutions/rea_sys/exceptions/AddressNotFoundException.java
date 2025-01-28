package my.reasolutions.rea_sys.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressNotFoundException extends RuntimeException {
    private final String msg;
}
