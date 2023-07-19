package com.dolphinevents.companyservice;

import java.util.List;

public interface CompanyServiceInterface {
    
    List<Company> findAllCompanies();

    Company findCompanyById(Integer id);

    Company findCompanyByName(String name);

    void deleteCompanyById(Integer id);

    Company saveCompany(Company company);
}
