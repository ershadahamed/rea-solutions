package my.reasolutions.rea_sys.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.reasolutions.rea_sys.customer.CustomerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressMapper {

    private final CustomerService customerService;

    public Address toAddress(@Valid AddressRequest request) {
        if (request == null) {
            return null;
        }

        return Address.builder()
                .streetTwo(request.streetOne())
                .streetTwo(request.streetTwo())
                .city(request.city())
                .state(State.valueOf(request.state()))
                .city(request.city())
                .houseType(request.houseType())
                .customer(
                        customerService.getCustomer(request.customerId())
                )
                .build();
    }

    public AddressResponse fromAddress(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getStreetOne(),
                address.getStreetTwo(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getHouseType(),
                address.getCustomer().getId()
        );
    }
}
