package my.reasolutions.rea_sys.customer;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.reasolutions.rea_sys.config.GetCurrent;
import my.reasolutions.rea_sys.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    private final GetCurrent getCurrentUser;

    public Long createCustomer(CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        customer.setUser(getCurrentUser.user());
        customer = customerRepository.save(customer);
        return customer.getId();
    }

    public List<CustomerResponse> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomerById(Long customerId) {
        return customerRepository
                .findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer not found with id: " + customerId)
                );
    }

    public Boolean existById(Long customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        if(request.id() == null) {
            throw new CustomerNotFoundException("Customer not found with id: " + null);
        }

        var customer = customerRepository.findById(request.id())
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer not found with id: " + request.id())
                );

        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.fullName())){
            customer.setFullName(request.fullName());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if(StringUtils.isNotBlank(request.phone())){
            customer.setPhone(request.phone());
        }
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
