package com.dolphinevents.companyservice;

import java.net.URI;
import java.util.List;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class CompanyController {
    
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> retrieveAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public EntityModel<Company> getCompanyById(@PathVariable int id) {

        Company company = companyService.findCompanyById(id);

        if(company == null) {
            throw new CompanyNotFoundException("Company with id " + id + "not found.");
        }

        EntityModel<Company> entityModel = EntityModel.of(company);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllCompanies());

        entityModel.add(link.withRel("all-companies"));

        return entityModel;
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompanyPerfil(@Valid @RequestBody Company company) {
        Company savedCompany = companyService.saveCompany(company);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompany.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/companies/{id}")
    public void removeCompany(@PathVariable Integer id ) {
        companyService.deleteCompanyById(id);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateCompany(@Valid @PathVariable Integer id, @RequestBody Company company) throws CompanyNotFoundException {
        Company updateCompany = companyService.findCompanyById(id);

        if(updateCompany == null) {
            throw new CompanyNotFoundException("Company with id " + id + " not found.");
        }

        updateCompany.setAddress(updateCompany.getAddress());
        updateCompany.setEmail(updateCompany.getEmail());
        updateCompany.setName(updateCompany.getName());
        updateCompany.setPassword(updateCompany.getPassword());
        updateCompany.setPhone(updateCompany.getPhone());
        updateCompany.setId(updateCompany.getId());

        return ResponseEntity.ok(updateCompany);
    }
}
