package com.iCompany.repositories.invoice;

import com.iCompany.entities.invoice.Invoice;
import com.iCompany.entities.invoice.InvoicePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by msadloch on 5/5/2016.
 */
@Repository
public interface InvoicePositionRepository extends JpaRepository<InvoicePosition, Long> {
}
