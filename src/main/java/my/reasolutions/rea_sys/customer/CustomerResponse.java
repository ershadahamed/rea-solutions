package my.reasolutions.rea_sys.customer;

public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        String phone
) {}
