package com.iCompany.entities.invoice;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Lukasz Franczuk on 14.02.16.
 */
@Entity
@Table(name = "INVOICE_POSITION", schema = "PUBLIC")
public class InvoicePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_POSITION_ID", unique = true, nullable = false)
    private Long invoicePositionId;

    @Column(name = "POSITION_NAME")
    private Integer positionNumber;

    @Column(name = "SERVICE_PRODUCT_NAME")
    private String serviceProductName;

    @Column(name = "SERVICE_PRODUCT_PKWIU")
    private String serviceProducPkwiu;

    @Column(name = "SERVICE_PRODUCT_AMOUNT")
    private BigDecimal serviceProductAmount;

    @Column(name = "SERVICE_PRODUCT_UNIT")
    private String serviceProductUnit;

    @Column(name = "SERVICE_PRODUCT_PRICE_NET")
    private BigDecimal serviceProductPriceNet;

    @Column(name = "SERVICE_PRODUCT_DISCOUNT")
    private BigDecimal serviceProductDiscount;

    @Column(name = "SERVICE_PRODUCT_FINAL_PRICE")
    private BigDecimal serviceProductFinalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VAT_RATE_ID")
    private VATRate vatRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public Long getInvoicePositionId() {
        return invoicePositionId;
    }

    public void setInvoicePositionId(Long invoicePositionId) {
        this.invoicePositionId = invoicePositionId;
    }

    public Integer getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getServiceProductName() {
        return serviceProductName;
    }

    public void setServiceProductName(String serviceProductName) {
        this.serviceProductName = serviceProductName;
    }

    public BigDecimal getServiceProductAmount() {
        return serviceProductAmount;
    }

    public void setServiceProductAmount(BigDecimal serviceProductAmount) {
        this.serviceProductAmount = serviceProductAmount;
    }

    public BigDecimal getServiceProductPriceNet() {
        return serviceProductPriceNet;
    }

    public void setServiceProductPriceNet(BigDecimal serviceProductPriceNet) {
        this.serviceProductPriceNet = serviceProductPriceNet;
    }

    public VATRate getVatRate() {
        return vatRate;
    }

    public void setVatRate(VATRate vatRate) {
        this.vatRate = vatRate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getServiceProducPkwiu() {
        return serviceProducPkwiu;
    }

    public void setServiceProducPkwiu(String serviceProducPkwiu) {
        this.serviceProducPkwiu = serviceProducPkwiu;
    }

    public String getServiceProductUnit() {
        return serviceProductUnit;
    }

    public void setServiceProductUnit(String serviceProductUnit) {
        this.serviceProductUnit = serviceProductUnit;
    }

    public BigDecimal getServiceProductDiscount() {
        return serviceProductDiscount;
    }

    public void setServiceProductDiscount(BigDecimal serviceProductDiscount) {
        this.serviceProductDiscount = serviceProductDiscount;
    }

    public BigDecimal getServiceProductFinalPrice() {
        return serviceProductFinalPrice;
    }

    public void setServiceProductFinalPrice(BigDecimal serviceProductFinalPrice) {
        this.serviceProductFinalPrice = serviceProductFinalPrice;
    }
}

