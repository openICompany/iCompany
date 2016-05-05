package com.iCompany.entities.invoice;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Lukasz Franczuk on 14.02.16.
 */
@Entity
@Table(name = "INVOICE", schema = "PUBLIC")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", unique = true, nullable = false)
    private Long invoiceId;

    @Column(name = "INVOICE_NUMBER", nullable = false)
    private String invoiceNumber;

    @Column(name = "INVOICE_DATE")
    private Date issueDate;

    @Column(name = "SELL_DATE")
    private Date sellDate;

    @Column(name = "ISSUE_PLACE")
    private String issuePlace;


    @Column(name="PAYMENT_DATE")
    private Date paymentDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoice")
    private List<InvoicePosition> invoicePositions;


    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public List<InvoicePosition> getInvoicePositions() {
        return invoicePositions;
    }

    public void setInvoicePositions(List<InvoicePosition> invoicePositions) {
        this.invoicePositions = invoicePositions;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}

