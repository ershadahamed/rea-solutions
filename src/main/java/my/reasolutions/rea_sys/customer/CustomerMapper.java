package my.reasolutions.rea_sys.customer;

import my.reasolutions.rea_sys.address.Address;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .fullName(request.fullName())
                .address(Address.builder()
                        .streetOne(request.address().getStreetOne())
                        .streetTwo(request.address().getStreetTwo())
                        .city(request.address().getCity())
                        .state(request.address().getState())
                        .zip(request.address().getZip())
                        .houseType(request.address().getHouseType())
                        .build())
                .email(request.email())
                .phone(request.phone())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(), customer.getFullName(), customer.getAddress(),
                customer.getEmail(), customer.getPhone()
        );
    }
}
