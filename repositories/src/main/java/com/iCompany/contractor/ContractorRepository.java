package com.iCompany.contractor;

import com.iCompany.entities.company.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kdziegie on 2016-05-24.
 */
@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
    public Contractor findByContractorId(Long contractorId);
}
