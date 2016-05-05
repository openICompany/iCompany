package com.iCompany.invoice.services;

import com.iCompany.entities.invoice.Invoice;
import com.iCompany.entities.invoice.InvoicePosition;
import com.iCompany.invoice.bo.InvoiceLineBo;
import com.iCompany.repositories.invoice.InvoicePositionRepository;
import com.iCompany.repositories.invoice.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msadloch on 4/26/2016.
 */
@Service
public class NewInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoicePositionRepository invoicePositionRepository;

    public void saveInvoice(String invoiceNumber, String issuePlace, Date issueDate, Date sellDate, Date dateOfPayment, List<InvoiceLineBo> invoiceLines) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setIssuePlace(issuePlace);
        invoice.setIssueDate(issueDate);
        invoice.setSellDate(sellDate);
        invoice.setPaymentDate(dateOfPayment);
        Invoice newInvoice = invoiceRepository.saveAndFlush(invoice);
        saveInvoiceLines(invoiceLines,newInvoice);

        invoiceRepository.save(invoice);
    }

    public void saveInvoiceLines(List<InvoiceLineBo> invoiceLines, Invoice invoice) {
        for (InvoiceLineBo invoiceLineBo : invoiceLines) {
            InvoicePosition invoicePosition = new InvoicePosition();
            invoicePosition.setServiceProductName(invoiceLineBo.getServiceProductName());
            invoicePosition.setServiceProducPkwiu(invoiceLineBo.getPkwiu());
            invoicePosition.setServiceProductAmount(invoiceLineBo.getQuantity());
            invoicePosition.setServiceProductUnit(invoiceLineBo.getUnit());
            invoicePosition.setServiceProductPriceNet(invoiceLineBo.getPrice());
            invoicePosition.setServiceProductDiscount(invoiceLineBo.getDiscount());
            invoicePosition.setServiceProductFinalPrice(invoiceLineBo.getFinalPrice());
            invoicePosition.setInvoice(invoice);
            invoicePositionRepository.saveAndFlush(invoicePosition);

        }


    }
}
