package my.reasolutions.rea_sys.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import my.reasolutions.rea_sys.address.Address;

public record CustomerRequest(
        Long id,
        @NotBlank(message = "Full name required")
        String fullName,
        @NotNull(message = "Address required")
        @Valid Address address,
        @NotBlank(message = "Email required")
        @Email(message = "Email provided not valid")
        String email,
        @NotBlank(message = "Phone number required")
        @Size(min = 10, max = 11, message = "Phone number length min 10 & max length 11")
        String phone
) {}
