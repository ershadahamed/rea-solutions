package my.reasolutions.rea_sys.address;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        Long id,
        @NotBlank(message = "Street on first line required")
        String streetOne,
        String streetTwo,
        @NotBlank(message = "City required")
        String city,
        @NotBlank(message = "State required")
        String state,
        @NotBlank(message = "Postcode required")
        String zip,
        @NotBlank(message = "House type required")
        String houseType,
        @NotBlank(message = "Customer id required")
        @Min(value = 1, message = "Must be a number and value greater than 0")
        Long customerId
) {
}
