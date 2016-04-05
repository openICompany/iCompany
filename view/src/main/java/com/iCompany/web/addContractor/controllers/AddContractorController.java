package com.iCompany.web.addContractor.controllers;


import com.iCompany.qualifier.ICompanyController;
import com.iCompany.web.addContractor.beans.AddContractorBean;
import com.iCompany.web.generic.GenericController;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Karol Dziegiel on 18.02.16.
 */
@ICompanyController
@ManagedBean
public class AddContractorController extends GenericController {

    @Autowired
    private AddContractorBean addContractorBean;

    //itemsIds representing items from view package
    private List<String> itemsIds;
    //values from form's input fields; the keys are represented by itemsIds from the line above
    //schema: Map<itemId, valueParsedFromField>
    private Map<String, String> inputFieldsData;

    private void getValuesFromFormInputFields(){
        itemsIds = new ArrayList<String>();
        itemsIds.add("bankAccountNumber");
        itemsIds.add("bankName");
        itemsIds.add("buildingNumber");
        itemsIds.add("city");
        itemsIds.add("contractorName");
        itemsIds.add("company");
        itemsIds.add("email");
        itemsIds.add("flatNumber");
        itemsIds.add("krs");
        itemsIds.add("regon");
        itemsIds.add("nip");
        itemsIds.add("phoneNumber");
        itemsIds.add("postCode");
        itemsIds.add("province");
        itemsIds.add("representative");
        itemsIds.add("street");
        itemsIds.add("shortContractorName");

        inputFieldsData= new HashMap<String, String>();
        inputFieldsData.put(itemsIds.get(0), addContractorBean.getBankAccountNumber());
        inputFieldsData.put(itemsIds.get(1), addContractorBean.getBankName());
        inputFieldsData.put(itemsIds.get(2), addContractorBean.getBuildingNumber());
        inputFieldsData.put(itemsIds.get(3), addContractorBean.getCity());
        inputFieldsData.put(itemsIds.get(4), addContractorBean.getContractorName());
        inputFieldsData.put(itemsIds.get(5), addContractorBean.getCompany());
        inputFieldsData.put(itemsIds.get(6), addContractorBean.getEmail());
        inputFieldsData.put(itemsIds.get(7), addContractorBean.getFlatNumber());
        inputFieldsData.put(itemsIds.get(8), addContractorBean.getKrs());
        inputFieldsData.put(itemsIds.get(9), addContractorBean.getRegon());
        inputFieldsData.put(itemsIds.get(10), addContractorBean.getNip());
        inputFieldsData.put(itemsIds.get(11), addContractorBean.getPhoneNumber());
        inputFieldsData.put(itemsIds.get(12), addContractorBean.getPostCode());
        inputFieldsData.put(itemsIds.get(13), addContractorBean.getProvince());
        inputFieldsData.put(itemsIds.get(14), addContractorBean.getRepresentative());
        inputFieldsData.put(itemsIds.get(15), addContractorBean.getStreet());
        inputFieldsData.put(itemsIds.get(16), addContractorBean.getShortContractorName());
    }

    public void validateMail() {
        String email = addContractorBean.getEmail();

         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         Pattern p = Pattern.compile(ePattern);
         Matcher m = p.matcher(email);

        if (!m.matches() || email == null) {
            FacesContext.getCurrentInstance().addMessage("grid:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Podany ciąg znaków nie jest e-mailem"));
        }
    }

    public void validateContractorName(){
        if (addContractorBean.getContractorName() == null){
            FacesContext.getCurrentInstance().addMessage("grid:contractorname", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Pole wymagane!"));
        }
    }

    public void saveContractor(){

    }

    public void validateData(){
        getValuesFromFormInputFields();
        for(String itemId : itemsIds){
            if((inputFieldsData.get(itemId) == null) || (inputFieldsData.get(itemId) == "null") || inputFieldsData.get(itemId).isEmpty() || (inputFieldsData.get(itemId) == "")){
                FacesContext.getCurrentInstance().addMessage("grid:"+itemId, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Pole wymagane!"));
            }
        }

    }

    public void validateDataOnBlur(){
        validateMail();
        RequestContext.getCurrentInstance().update("grid");
    }
}