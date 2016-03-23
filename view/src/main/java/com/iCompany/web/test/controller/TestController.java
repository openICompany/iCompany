package com.iCompany.web.test.controller;

import com.iCompany.qualifier.ICompanyController;
import com.iCompany.services.user.NewUserService;
import com.iCompany.web.generic.GenericController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;

/**
 * Created by lukasz on 24.03.16.
 */
@ICompanyController
@ManagedBean
public class TestController extends GenericController {

    @Autowired
    private NewUserService newUserService;

    public void testDB() {
        newUserService.saveTestUser();
        logger.info("Nowy użytkownik zapisany do bazy danych!!!");
    }
}
