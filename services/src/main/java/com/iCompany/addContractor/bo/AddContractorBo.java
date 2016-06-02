package com.iCompany.addContractor.bo;

/**
 * Created by kdziegie on 2016-05-25.
 */
public class AddContractorBo {
    private String contractorName;
    private String shortContractorName;
    private String street;
    private String buildingNumber;
    private String flatNumber;
    private String postCode;
    private String city;
    private String province;
    private String representative;
    private String bankName;
    private String bankAccountNumber;
    private String nip;
    private String regon;
    private String krs;
    private String phoneNumber;
    private String email;
    private Long companyId;

    public AddContractorBo(String bankAccountNumber, String bankName, String buildingNumber,
                           String city, Long companyId, String contractorName, String email,
                           String flatNumber, String krs, String nip, String phoneNumber,
                           String postCode, String province, String regon, String representative,
                           String shortContractorName, String street) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.companyId = companyId;
        this.contractorName = contractorName;
        this.email = email;
        this.flatNumber = flatNumber;
        this.krs = krs;
        this.nip = nip;
        this.phoneNumber = phoneNumber;
        this.postCode = postCode;
        this.province = province;
        this.regon = regon;
        this.representative = representative;
        this.shortContractorName = shortContractorName;
        this.street = street;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKrs() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs = krs;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getShortContractorName() {
        return shortContractorName;
    }

    public void setShortContractorName(String shortContractorName) {
        this.shortContractorName = shortContractorName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
