package com.iCompany.web.test.bean;

import com.iCompany.qualifier.ICompanyBackingBean;
import com.iCompany.web.generic.GenericBackingBean;

import javax.faces.bean.ManagedBean;

/**
 * Created by Lukasz Franczuk on 12.02.16.
 */
@ICompanyBackingBean
@ManagedBean
public class HelloWorldBean extends GenericBackingBean {

    private String testString = "Hello World";

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

}
