package my.reasolutions.rea_sys.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper mapper;

    public Long createAddress(@Valid AddressRequest request) {
        return null;
    }

    public List<AddressResponse> getAddress() {
        return null;
    }

    public AddressResponse getAddressById(Long addressId) {
        return null;
    }

    public Boolean existById(Long addressId) {
        return null;
    }

    public void updateAddress(@Valid AddressRequest request) {

    }

    public void deleteAddress(Long addressId) {

    }
}
