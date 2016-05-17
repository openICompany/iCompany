package com.iCompany.web.invoice.controllers;

import com.iCompany.qualifier.ICompanyController;
import com.iCompany.invoice.services.NewInvoiceService;
import com.iCompany.web.invoice.beans.NewInvoiceBean;
import com.iCompany.invoice.bo.InvoiceLineBo;
import com.iCompany.web.invoice.utilities.Utils;
import com.sun.faces.facelets.tag.IterationStatus;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * Created by msadloch on 2/16/2016.
 */
@ManagedBean
@ICompanyController
public class NewInvoiceController {

    @Autowired
    private NewInvoiceBean newInvoiceBean;

    @Autowired
    private NewInvoiceService newInvoiceService;


    public void saveInvoice() {
        newInvoiceService.saveInvoice(newInvoiceBean.getInvoiceID(), newInvoiceBean.getIssuePlace(), newInvoiceBean.getIssueDate(), newInvoiceBean.getSellDate(), newInvoiceBean.getDateOfPayment(), newInvoiceBean.getInvoiceLines());
    }




    public void addInvoiceLine() {
        List<InvoiceLineBo> invoiceLineList = newInvoiceBean.getInvoiceLines();
        InvoiceLineBo invoiceLineBo = new InvoiceLineBo();
        invoiceLineBo.setVat(Utils.getVatDefault());
        invoiceLineList.add(invoiceLineBo);
        newInvoiceBean.setInvoiceLines(invoiceLineList);
    }

    public void calculateFinalPrice(IterationStatus iterationStatus) {
        InvoiceLineBo invoicelineBO = newInvoiceBean.getInvoiceLines().get(iterationStatus.getIndex());
        BigDecimal discount = new BigDecimal(0);
        BigDecimal quantity = new BigDecimal(1);
        if (invoicelineBO.getDiscountString() != null && !invoicelineBO.getDiscountString().isEmpty()) {
            discount = new BigDecimal(invoicelineBO.getDiscountString().replace(",", ".")).divide(new BigDecimal(100));
        }
        if (invoicelineBO.getQuantityString() != null && !invoicelineBO.getQuantityString().isEmpty()) {
            quantity = new BigDecimal(invoicelineBO.getQuantityString().replace(",", "."));
        }
        if (invoicelineBO.getPriceString() != null && !invoicelineBO.getPriceString().isEmpty()) {
            BigDecimal price = new BigDecimal(invoicelineBO.getPriceString().replace(",", "."));
            BigDecimal afterDiscount = price.multiply(new BigDecimal(1).subtract(discount));
            invoicelineBO.setFinalPrice(afterDiscount.multiply(quantity));
            RequestContext.getCurrentInstance().update("newInvoiceMainPageForm:j_idt55:" + iterationStatus.getIndex() + ":finalPriceInputId");
            calculateTotalPriceNetAndVat();
        }


    }

    public void calculateTotalPriceNetAndVat() {
        BigDecimal totalNet = new BigDecimal(0);
        BigDecimal totalVat = new BigDecimal(0);
        MathContext mc = new MathContext(2);
        for (InvoiceLineBo invoiceLineBo : newInvoiceBean.getInvoiceLines()) {

            BigDecimal vat = invoiceLineBo.getVat();
            totalNet = totalNet.add(invoiceLineBo.getFinalPrice());
            if (vat != null)
                totalVat = totalVat.add(invoiceLineBo.getFinalPrice().multiply(vat, mc));

        }
        if (totalNet != null) {
            newInvoiceBean.setTotalPriceNet(totalNet);

            RequestContext.getCurrentInstance().update("newInvoiceMainPageForm:totalNetId");
        }
        if (totalVat != null) {
            newInvoiceBean.setTotalVat(totalVat);
            RequestContext.getCurrentInstance().update("newInvoiceMainPageForm:totalTaxId");
        }


    }


    public void removeInvoiceLine(IterationStatus iterationStatus) {
        List<InvoiceLineBo> invoicelineList = newInvoiceBean.getInvoiceLines();
        invoicelineList.remove(iterationStatus.getIndex());
        newInvoiceBean.setInvoiceLines(invoicelineList);
    }
//        UIComponent component = FacesContext.getCurrentInstance().getViewRoot().findComponent("newInvoiceMainPageForm:fvLine");
//        if (component != null) {
//            Panel p = new Panel();
//            p.setClosable(true);
//            p.setHeader("Test");
//            p.setVisible(true);
//            component.getChildren().add(p);
//        }
//    }

    public void setNewInvoiceBean(NewInvoiceBean newInvoiceBean) {
        this.newInvoiceBean = newInvoiceBean;
    }
}
