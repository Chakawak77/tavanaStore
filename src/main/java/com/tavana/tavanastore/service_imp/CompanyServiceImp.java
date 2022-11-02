package com.tavana.tavanastore.service_imp;

import com.tavana.tavanastore.dto.CompanytDTO;
import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.dto.ProductDTO;
import com.tavana.tavanastore.entity.Company;
import com.tavana.tavanastore.entity.Customer;
import com.tavana.tavanastore.entity.Product;
import com.tavana.tavanastore.repository.CompanyRepository;
import com.tavana.tavanastore.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public CompanytDTO save(CompanytDTO companytDTO) {
        Company company = companytDTO.map();
        company = repository.save(company);
        return CompanytDTO
                .builder()
                .name(company.getName())
                .address(company.getAddress())
                .logo(company.getLogo())
                .build();
    }

    @Override
    public CompanytDTO update(CompanytDTO companytDTO) {
        CompanytDTO updateCompanyDTO = findById(companytDTO.getId());
        Company company = companytDTO.map();
        company = repository.save(company);
        return CompanytDTO
                .builder()
                .name(company.getName())
                .address(company.getAddress())
                .logo(company.getLogo())
                .build();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public CompanytDTO findById(Long id) {
        Optional<Company> optionalCompany = repository.findById(id);
        if (optionalCompany.isEmpty())
            throw new RuntimeException("Not Found!");
        return new CompanytDTO(optionalCompany.get());
    }
}
