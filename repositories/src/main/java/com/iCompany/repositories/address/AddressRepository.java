package com.iCompany.repositories.address;

import com.iCompany.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kdziegie on 2016-06-02.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
