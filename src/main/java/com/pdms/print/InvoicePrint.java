/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.print;

import com.pdms.display.CustomerDisplay;
import com.pdms.display.InvoiceDisplay;
import com.pdms.display.InvoiceItemDisplay;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Suresh
 */
public class InvoicePrint {

    Map<String, Object> parameters;
    List<InvoiceItemDisplay> itemDisplays;

    public InvoicePrint(InvoiceDisplay display) {
        parameters = new HashMap<>();

        parameters.put("invoiceNumber", String.valueOf(display.getId()));
        parameters.put("invoiceDate", display.getDog());
        parameters.put("fromDate", display.getFromDate());
        parameters.put("toDate", display.getToDate());

        parameters.put("payableAmount", display.getPayableAmount());
        parameters.put("discount", display.getDiscount());
        parameters.put("invoiceAmount", display.getTotalAmount());

        CustomerDisplay customerDisplay = display.getCustomerDisplay();
        parameters.put("customerName", customerDisplay.getName());
        parameters.put("mobile", customerDisplay.getMobileNo());
        parameters.put("address", customerDisplay.getAddress());
        parameters.put("pincode", customerDisplay.getPincode());
        itemDisplays = display.getInvoiceItemDisplays();
    }

    public void generatePDF() throws Exception {
        InputStream inputStream = Print.getInputStream("jasper/invoice.jrxml");
        Print.print(parameters, itemDisplays, inputStream, "C:/temp/invoice.pdf");
    }
}
