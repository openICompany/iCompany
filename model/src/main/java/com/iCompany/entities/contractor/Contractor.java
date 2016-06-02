package com.iCompany.entities.contractor;

import com.iCompany.entities.address.Address;
import com.iCompany.entities.company.Company;

import javax.persistence.*;

/**
 * Created by Lukasz Franczuk on 14.02.16.
 */
@Entity
@Table(name = "CONTRACTOR", schema = "PUBLIC")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTRACTOR_ID")
    private Long contractorId;

    @Column(name = "CONTRACTOR_NAME")
    private String contractorName;

    @Column(name = "SHORT_CONTRACTOR_NAME")
    private String shortContractorName;

    @Column(name = "REGON")
    private String regon;

    @Column(name = "NIP")
    private String nip;

    @Column(name = "KRS")
    private String krs;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_ACCOUNT_NUMBER")
    private String bankAccountNumber;

    @Column(name = "REPRESENTATIVE")
    private String representative;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public Contractor(Address address, String contractorName, String shortContractorName, String regon,
                      String nip, String krs, String bankName, String bankAccountNumber,
                      String representative, String phoneNumber, String email, Company company) {
        this.address = address;
        this.contractorName = contractorName;
        this.shortContractorName = shortContractorName;
        this.regon = regon;
        this.nip = nip;
        this.krs = krs;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.representative = representative;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.company = company;
    }

    public Contractor() {

    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getShortContractorName() {
        return shortContractorName;
    }

    public void setShortContractorName(String shortContractorName) {
        this.shortContractorName = shortContractorName;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKrs() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs = krs;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
