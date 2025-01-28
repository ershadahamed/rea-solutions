package my.reasolutions.rea_sys.address;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.reasolutions.rea_sys.exceptions.AddressNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper mapper;

    public Long createAddress(@Valid AddressRequest request) {
        var address = mapper.toAddress(request);
        addressRepository.save(address);
        return address.getId();
    }

    public List<AddressResponse> getAddress() {
        return addressRepository.findAll()
                .stream()
                .map(mapper::fromAddress)
                .collect(Collectors.toList());
    }

    public AddressResponse getAddressById(Long addressId) {
        return addressRepository
                .findById(addressId)
                .map(mapper::fromAddress)
                .orElseThrow(
                        () -> new AddressNotFoundException("Address not found with id " + addressId)
                );
    }

    public Boolean existById(Long addressId) {
        return addressRepository.existsById(addressId);
    }

    public void updateAddress(@Valid AddressRequest request) {
        if (request == null) {
            throw new AddressNotFoundException("Address not found");
        }

        var address = addressRepository.findById(request.id()).orElseThrow(
                () -> new AddressNotFoundException("Address not found with id " + request.id())
        );

        mergeAddress(address, request);
        addressRepository.save(address);
    }

    private void mergeAddress(Address address, @Valid AddressRequest request) {
        if(StringUtils.isNotBlank(request.streetOne())){
            address.setStreetOne(request.streetOne());
        }
        if(StringUtils.isNotBlank(request.streetTwo())){
            address.setStreetOne(request.streetTwo());
        }
        if(StringUtils.isNotBlank(request.city())){
            address.setStreetOne(request.city());
        }
        if(StringUtils.isNotBlank(request.state())){
            address.setStreetOne(request.state());
        }
        if(StringUtils.isNotBlank(request.zip())){
            address.setStreetOne(request.zip());
        }
        if(StringUtils.isNotBlank(request.houseType())){
            address.setStreetOne(request.houseType());
        }
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public Address getAddress(Long addressId) {
        return addressRepository
                .findById(addressId)
                .orElseThrow(
                        () -> new AddressNotFoundException("Address not found with id " + addressId)
                );
    }
}
