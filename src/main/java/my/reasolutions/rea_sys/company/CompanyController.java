package my.reasolutions.rea_sys.company;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Company")
@RequestMapping("companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Long> createCompany(@RequestBody @Valid CompanyRequest request) {
        return ResponseEntity.ok(companyService.createCompany(request));
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getCompanies());
    }

    @GetMapping("/{company-id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable("company-id") Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @GetMapping("/exist/{company-id}")
    public ResponseEntity<Boolean> companyExistById(@PathVariable("company-id") Long companyId) {
        return ResponseEntity.ok(companyService.existById(companyId));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CompanyRequest request){
        companyService.updateCompany(request);
        return ResponseEntity.accepted().build();
    }
}
