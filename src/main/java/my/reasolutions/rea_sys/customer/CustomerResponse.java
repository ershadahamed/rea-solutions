package my.reasolutions.rea_sys.customer;

import my.reasolutions.rea_sys.address.Address;

public record CustomerResponse(
        Long id,
        String fullName,
        Address address,
        String email,
        String phone
) {}
