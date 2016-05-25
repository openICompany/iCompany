package com.iCompany.addContractor;

import com.iCompany.entities.company.Company;
import com.iCompany.entities.company.Contractor;

import java.util.List;

/**
 * Created by kdziegie on 2016-05-24.
 */
public interface AddContractorService {
    void saveContractor(Contractor contractor);
    List<Company> getUserCompanies(String userName);
}
