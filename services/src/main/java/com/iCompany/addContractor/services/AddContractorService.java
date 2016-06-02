package com.iCompany.addContractor.services;

import com.iCompany.addContractor.bo.AddContractorBo;
import com.iCompany.entities.company.Company;
import com.iCompany.entities.user.User;

import java.util.List;

/**
 * Created by kdziegie on 2016-05-24.
 */
public interface AddContractorService {
    List<Company> getUserCompanies(User user);
    void saveContractor(AddContractorBo addContractorBo);
}
