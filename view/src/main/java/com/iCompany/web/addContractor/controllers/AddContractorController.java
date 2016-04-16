package com.iCompany.web.addContractor.controllers;


import com.iCompany.qualifier.ICompanyController;
import com.iCompany.web.addContractor.beans.AddContractorBean;
import com.iCompany.web.generic.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

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

    //itemsIds representing items from view package (ids from form's fields)
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

    private boolean validateMail() {
        String email = addContractorBean.getEmail();

         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         Pattern p = Pattern.compile(ePattern);
         Matcher m = p.matcher(email);

        if (!m.matches() || email == null || email.equals("")) {
            FacesContext.getCurrentInstance().addMessage("grid:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Podany ciąg znaków nie jest e-mailem"));
            return false;
        }else return true;
    }

    private  boolean validateKrs(){

        if (inputFieldsData.get("krs").length() != 10) {
            FacesContext.getCurrentInstance().addMessage("grid:krs", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Nieprawidłowy numer KRS"));
            return false;
        }else return true;
    }

    private boolean validateRegon() {
        String regon = inputFieldsData.get("regon");
        int checksum = 0;
        int[] weigths9 = {8, 9, 2, 3, 4, 5, 6, 7};
        int[] weigths14 = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};
        switch (regon.length()){
            case 9: {
                for (int i = 0; i < weigths9.length; i++) {
                    checksum += Integer.parseInt("" + regon.charAt(i)) * weigths9[i];
                }
                        if(checksum % 11 != Integer.parseInt(""+regon.charAt(8))){
                            FacesContext.getCurrentInstance().addMessage("grid:regon", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędny REGON! "));
                            return false;
                        } else return true;

                    }
            case 14: {
                        for (int i = 0; i < weigths14.length; i++) {
                            checksum += Integer.parseInt("" + regon.charAt(i)) * weigths14[i];
                        }
                        if(checksum%11 != Integer.parseInt(""+regon.charAt(13))){
                            FacesContext.getCurrentInstance().addMessage("grid:regon", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędny REGON!"));
                            return false;
                        }else return true;

                    }
            default: {
                FacesContext.getCurrentInstance().addMessage("grid:regon", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędny REGON!"));
                return false;
            }
        }
    }


    private boolean validateRequiredFields(){
        getValuesFromFormInputFields();
        boolean isValid = false;
        for(String itemId : itemsIds) {
            //check only fields that are required not to be null
            if (!(itemId.equals("shortContractorName") || itemId.equals("flatNumber") || itemId.equals("province"))) {
                if (inputFieldsData.get(itemId) == null || inputFieldsData.get(itemId).equals("null") || inputFieldsData.get(itemId).isEmpty() || inputFieldsData.get(itemId).equals("")) {
                    FacesContext.getCurrentInstance().addMessage("grid:" + itemId, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Pole wymagane!"));
                    isValid = false;
                } else isValid = true;
            }
        }
        return isValid;
    }


    private boolean validateNip(){
        String nip = inputFieldsData.get("nip");
        int checksum = 0;
        int[] weigths = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        Pattern nipPattern1 = Pattern.compile("^\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d\\d$");
        Pattern nipPattern2 = Pattern.compile("^\\d\\d\\d-\\d\\d\\d-\\d\\d-\\d\\d$");
        Pattern nipPattern3 = Pattern.compile("^\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d$");
        Matcher matcher1 = nipPattern1.matcher(nip);
        Matcher matcher2 = nipPattern2.matcher(nip);
        Matcher matcher3 = nipPattern3.matcher(nip);
        nip = nip.replaceAll("-", "");
        if (matcher1.matches() || matcher2.matches() || matcher3.matches()) {
            for (int i = 0; i < weigths.length; i++) {
                if (nip.charAt(i) != '-') {
                    checksum += Integer.parseInt("" + nip.charAt(i)) * weigths[i];
                }
            }
            if (checksum % 11 != Integer.parseInt("" + nip.charAt(nip.length() - 1))) {
                FacesContext.getCurrentInstance().addMessage("grid:nip", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędny NIP!"));
                return false;
            } else return true;
        }else {
            FacesContext.getCurrentInstance().addMessage("grid:nip", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Błędny NIP!"));
            return false;
        }
    }

    public void saveContractor(){
        validateRequiredFields();
        validateMail();
        validateKrs();
        validateRegon();
        validateNip();
        /*if (validateRequiredFields() && validateMail() && validateRegon() && validateKrs() && validateNip()) {
            //safe the data

        }*/
    }

}