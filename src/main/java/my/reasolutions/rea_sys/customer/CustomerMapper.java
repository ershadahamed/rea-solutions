package my.reasolutions.rea_sys.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }

        return Customer.builder()
                .fullName(request.fullName())
                .email(request.email())
                .phone(request.phone())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(), customer.getFullName(),
                customer.getEmail(), customer.getPhone()
        );
    }
}
