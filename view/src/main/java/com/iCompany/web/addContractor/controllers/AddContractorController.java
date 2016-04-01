package com.iCompany.web.addContractor.controllers;


import com.iCompany.qualifier.ICompanyController;
import com.iCompany.web.addContractor.beans.AddContractorBean;
import com.iCompany.web.generic.GenericController;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by Karol Dziegiel on 18.02.16.
 */
@ICompanyController
@ManagedBean
public class AddContractorController extends GenericController {

    @Autowired
    private AddContractorBean addContractorBean;

    public void validateMail() {
        String mail = addContractorBean.getEmail();
        if (!mail.contains("@")) {
            FacesContext.getCurrentInstance().addMessage("grid:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd", "Podany ciąg znaków nie jest e-mailem"));
            RequestContext.getCurrentInstance().update("grid");
        }
    }
}
