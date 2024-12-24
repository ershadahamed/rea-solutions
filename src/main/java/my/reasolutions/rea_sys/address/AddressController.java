package my.reasolutions.rea_sys.address;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Address")
@RequestMapping("address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Long> createAddress(@RequestBody @Valid AddressRequest request){
        return ResponseEntity.ok(addressService.createAddress(request));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAddress());
    }

    @GetMapping("/{address-id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("address-id") Long addressId) {
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }

    @GetMapping("/exist/{address-id}")
    public ResponseEntity<Boolean> addressExistById(@PathVariable("address-id") Long addressId) {
        return ResponseEntity.ok(addressService.existById(addressId));
    }

    @PutMapping
    public ResponseEntity<Void> updateAddress(@RequestBody @Valid AddressRequest request){
        addressService.updateAddress(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{address-id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("address-id") Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.accepted().build();
    }
}
