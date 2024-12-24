package my.reasolutions.rea_sys.company;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    public Long createCompany(@Valid CompanyRequest request) {
        var company = mapper.toCompany(request);
        return companyRepository.save(company).getId();
    }

    public List<CompanyResponse> getCompanies() {
        return companyRepository
                .findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CompanyResponse getCompanyById(Long companyId) {
        return companyRepository
                .findById(companyId)
                .map(mapper::fromCustomer)
                .orElseThrow(
                        () -> new EntityNotFoundException("Company not found with id " + companyId)
                );
    }

    public Boolean existById(Long companyId) {
        return companyRepository.existsById(companyId);
    }

    public void updateCompany(@Valid CompanyRequest request) {
        if(request.id() == null) {
            throw new EntityNotFoundException("Company not found with id: " + null);
        }

        var company = companyRepository.findById(request.id())
                .orElseThrow(
                        () -> new EntityNotFoundException("Company not found with id: " + request.id())
                );
        mergeCompany(company, request);
        companyRepository.save(company);
    }

    private void mergeCompany(Company company, @Valid CompanyRequest request) {
        if(StringUtils.isNotBlank(request.name())){
            company.setName(request.name());
        }
        if(StringUtils.isNotBlank(request.companyRegistration())){
            company.setCompanyRegistration(request.companyRegistration());
        }
        if(StringUtils.isNotBlank(request.streetOne())){
            company.setStreetOne(request.streetOne());
        }
        if(StringUtils.isNotBlank(request.streetTwo())){
            company.setStreetTwo(request.streetTwo());
        }
        if(StringUtils.isNotBlank(request.city())){
            company.setCity(request.city());
        }
        if(StringUtils.isNotBlank(request.state())){
            company.setState(request.state());
        }
        if(StringUtils.isNotBlank(request.zip())){
            company.setZip(request.zip());
        }
        if(StringUtils.isNotBlank(request.phone())){
            company.setPhone(request.phone());
        }
        if(StringUtils.isNotBlank(request.email())){
            company.setEmail(request.email());
        }
    }
}
