package com.iCompany.repositories.invoice;

import com.iCompany.entities.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by msadloch on 4/26/2016.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long>{

    public Invoice findByInvoiceId(Long invoiceId);


}
