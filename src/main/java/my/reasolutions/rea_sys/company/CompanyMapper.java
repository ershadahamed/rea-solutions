package my.reasolutions.rea_sys.company;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.reasolutions.rea_sys.config.GetCurrent;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyMapper {
    private final GetCurrent getCurrent;

    public Company toCompany(@Valid CompanyRequest request) {
        if (request == null) {
            return null;
        }
        return Company.builder()
                .name(request.name())
                .companyRegistration(request.companyRegistration())
                .streetOne(request.streetOne())
                .streetTwo(request.streetTwo())
                .city(request.city())
                .state(request.state())
                .zip(request.zip())
                .phone(request.phone())
                .email(request.email())
                .user(getCurrent.user(request.userId()))
                .build();
    }

    public CompanyResponse fromCustomer(Company company) {
        return new CompanyResponse(
                company.getId(), company.getName(), company.getCompanyRegistration(), company.getStreetOne(), company.getStreetTwo(),
                company.getCity(), company.getState(), company.getZip(), company.getPhone(), company.getEmail(), company.getUser().getId()
        );
    }
}
