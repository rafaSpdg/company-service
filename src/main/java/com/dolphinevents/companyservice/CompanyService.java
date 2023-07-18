package com.dolphinevents.companyservice;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class CompanyService implements CompanyServiceInterface{

    private CompanyRepository companyRepository;
    
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Integer id) throws CompanyNotFoundException{
        Company company = companyRepository.findById(id).get();

        if(company == null) {
            throw new CompanyNotFoundException("Company with id " + id + "does not exists.");
        }
        return company;
    }

    @Override
    public Company findCompanyByName(String name) throws CompanyNotFoundException{
        Company company = companyRepository.findByName(name);

        if (company == null) {
            throw new CompanyNotFoundException("Company with name " + name + " not found.");
        }

        return company;
    }

    @Override
    public void deleteCompanyById(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        companyRepository.save(company);

        return company;
    }
}
