package com.iCompany.repositories.company;

import com.iCompany.entities.company.Company;
import com.iCompany.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kdziegie on 2016-05-24.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Company findByCompanyId(Long companyId);

    public List<Company> findByUser(User user);
}
