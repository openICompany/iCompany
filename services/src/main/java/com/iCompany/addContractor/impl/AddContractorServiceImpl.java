package com.iCompany.addContractor.impl;

import com.iCompany.addContractor.AddContractorService;
import com.iCompany.company.CompanyRepository;
import com.iCompany.contractor.ContractorRepository;
import com.iCompany.entities.company.Company;
import com.iCompany.entities.company.Contractor;
import com.iCompany.entities.user.User;
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

    public void saveContractor(Contractor contractor) {

    }

    public List<Company> getUserCompanies(String userName) {
        User user = userRepository.findByName(userName);
        return companyRepository.findByUser(user);
    }
}
