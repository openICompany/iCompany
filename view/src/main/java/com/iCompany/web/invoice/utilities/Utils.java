package com.iCompany.web.invoice.utilities;

import java.math.BigDecimal;

/**
 * Created by msadloch on 4/7/2016.
 */
public class Utils {

    final static BigDecimal VAT_DEFAULT = new BigDecimal(0.23);
    public static BigDecimal getVatDefault() {
        return VAT_DEFAULT;
    }
}
