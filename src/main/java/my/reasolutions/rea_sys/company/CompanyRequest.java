package my.reasolutions.rea_sys.company;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyRequest(
        Long id,
        @NotBlank(message = "Company name required")
        String name,
        @NotBlank(message = "Company registration id required")
        String companyRegistration,
        @NotBlank(message = "Street on first line required")
        String streetOne,
        String streetTwo,
        @NotBlank(message = "City required")
        String city,
        @NotBlank(message = "State required")
        String state,
        @NotBlank(message = "Postcode required")
        String zip,
        @NotBlank(message = "Phone number required")
        @Size(min = 10, max = 11, message = "Phone number length min 10 & max length 11")
        String phone,
        @NotBlank(message = "Email required")
        @Email(message = "Email provided not valid")
        String email,
        @NotBlank(message = "User id required")
        @Min(value = 1, message = "Must be a number and value greater than 0")
        Long userId
) {
}
