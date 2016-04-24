package com.iCompany.web.userCustomization.controllers;

import com.iCompany.qualifier.ICompanyController;
import com.iCompany.web.generic.GenericController;
import com.iCompany.web.userCustomization.beans.UserCustomizationBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * Created by Kamil Dudek on 4/24/16.
 */
@ICompanyController
@ManagedBean
public class UserCustomizationController extends GenericController {

    @Autowired
    private UserCustomizationBean userCustomizationBean;

    @PostConstruct
    public void init(){
        //TODO: fetch user companies and set it on backing bean here?
    }
}
