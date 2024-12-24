package my.reasolutions.rea_sys.company;

public record CompanyResponse(
        Long id,
        String name,
        String companyRegistration,
        String streetOne,
        String streetTwo,
        String city,
        String state,
        String zip,
        String phone,
        String email,
        Long userId
) {
}
