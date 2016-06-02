package com.iCompany.addContractor.services.impl;

import com.iCompany.addContractor.bo.AddContractorBo;
import com.iCompany.addContractor.services.AddContractorService;
import com.iCompany.entities.address.Address;
import com.iCompany.entities.company.Company;
import com.iCompany.entities.contractor.Contractor;
import com.iCompany.entities.user.User;
import com.iCompany.repositories.address.AddressRepository;
import com.iCompany.repositories.company.CompanyRepository;
import com.iCompany.repositories.contractor.ContractorRepository;
import com.iCompany.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kdziegie on 2016-05-24.
 */
@Service
public class AddContractorServiceImpl implements AddContractorService {

    @Autowired
    ContractorRepository contractorRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public void saveContractor(AddContractorBo addContractorBo) {
        Address address = new Address(addContractorBo.getBuildingNumber(), addContractorBo.getCity(), addContractorBo.getFlatNumber(),
                addContractorBo.getPostCode(), addContractorBo.getProvince(), addContractorBo.getStreet());
        addressRepository.saveAndFlush(address);
        Company company = companyRepository.findByCompanyId(addContractorBo.getCompanyId());
        Contractor contractor = new Contractor(address, addContractorBo.getContractorName(), addContractorBo.getShortContractorName(),
                addContractorBo.getRegon(), addContractorBo.getNip(), addContractorBo.getKrs(),
                addContractorBo.getBankName(), addContractorBo.getBankAccountNumber(), addContractorBo.getRepresentative(), addContractorBo.getPhoneNumber(),
                addContractorBo.getEmail(), company);
        contractorRepository.saveAndFlush(contractor);
    }
    public List<Company> getUserCompanies(User user) {
        return companyRepository.findByUser(user);
    }
}
