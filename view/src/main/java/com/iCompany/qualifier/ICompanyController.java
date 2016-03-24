package com.iCompany.qualifier;

import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lukasz on 23.03.16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@RequestScoped
public @interface ICompanyController {
}
