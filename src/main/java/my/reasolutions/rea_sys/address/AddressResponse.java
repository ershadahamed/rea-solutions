package my.reasolutions.rea_sys.address;

public record AddressResponse(
        Long id,
        String streetOne,
        String streetTwo,
        String city,
        State state,
        String zip,
        String houseType,
        Long customerId
) {
}
