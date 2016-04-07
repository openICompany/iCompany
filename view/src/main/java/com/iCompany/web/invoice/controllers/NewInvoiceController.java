package com.iCompany.web.invoice.controllers;

import com.iCompany.web.invoice.beans.NewInvoiceBean;
import com.iCompany.web.invoice.bo.InvoiceLineBo;
import com.sun.faces.facelets.tag.IterationStatus;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

/**
 * Created by msadloch on 2/16/2016.
 */
@ManagedBean
@RequestScoped
public class NewInvoiceController {

    @ManagedProperty(value = "#{newInvoiceBean}")
    private NewInvoiceBean newInvoiceBean;

    final static BigDecimal VAT = new BigDecimal(0.23);

    public void addInvoiceLine() {
        List<InvoiceLineBo> invoiceLineList = newInvoiceBean.getInvoiceLines();
        InvoiceLineBo invoiceLineBo=new InvoiceLineBo();
        invoiceLineBo.setVat(VAT);
        invoiceLineList.add(invoiceLineBo);
        newInvoiceBean.setInvoiceLines(invoiceLineList);
    }

    public void calculateFinalPrice(IterationStatus iterationStatus) {
        InvoiceLineBo invoicelineBO = newInvoiceBean.getInvoiceLines().get(iterationStatus.getIndex());
        BigDecimal discount = new BigDecimal(0);
        BigDecimal quantity = new BigDecimal(1);
        if (invoicelineBO.getDiscount() != null)
            discount = invoicelineBO.getDiscount().divide(new BigDecimal(100));
        if (invoicelineBO.getQuantity() != null)
            quantity = invoicelineBO.getQuantity();
        if (invoicelineBO.getPrice() != null) {
            BigDecimal price = invoicelineBO.getPrice();
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
