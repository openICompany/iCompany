package com.iCompany.web.invoice.beans;

import com.iCompany.web.invoice.bo.InvoiceLineBo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by msadloch on 2/16/2016.
 */

@ManagedBean
@ViewScoped
public class NewInvoiceBean {

    private String issuePlace;
    private Date issueDate;
    private Date sellDate;
    private Date dateOfPayment;
    private BigDecimal totalPriceNet;
    private BigDecimal totalVat;
    private  List<InvoiceLineBo> invoiceLines;
    final static BigDecimal VAT = new BigDecimal(0.23);

    public BigDecimal getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(BigDecimal totalVat) {
        this.totalVat = totalVat;
    }

    @PostConstruct
    public void init() {
        invoiceLines = new ArrayList<InvoiceLineBo>();
        InvoiceLineBo invoiceLineBo=new InvoiceLineBo();
        invoiceLineBo.setVat(VAT);
        invoiceLines.add(invoiceLineBo);


    }


 /*   @PostConstruct
    public void init() {
        testList = new ArrayList<String>();
        testList.add("");

    }*/

    public List<InvoiceLineBo> getInvoiceLines() {
        return invoiceLines;
    }

    public BigDecimal getTotalPriceNet() { return totalPriceNet;    }

    public void setTotalPriceNet(BigDecimal finalPriceNet) { this.totalPriceNet = finalPriceNet;    }

    public void setInvoiceLines(List<InvoiceLineBo> invoiceLines) { this.invoiceLines = invoiceLines;    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
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

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}
