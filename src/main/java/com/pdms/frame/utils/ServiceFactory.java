/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.frame.utils;

import com.pdms.service.CustomerService;
import com.pdms.service.InvoiceService;
import com.pdms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Suresh
 */
@Component
@Qualifier("serviceFactory")
public class ServiceFactory {
    
    private static CustomerService customerService;   
    private static ItemService itemService;    
    private static InvoiceService invoiceService;
    
    
    public static CustomerService getCustomerService() {
        return customerService;
    }
    
    @Autowired
    public static void setCustomerService(CustomerService customerService) {
        ServiceFactory.customerService = customerService;
    }
    
    
    public static ItemService getItemService() {
        return itemService;
    }

    @Autowired
    public static void setItemService(ItemService itemService) {
        ServiceFactory.itemService = itemService;
    }

    public static InvoiceService getInvoiceService() {
        return invoiceService;
    }
    
    @Autowired
    public static void setInvoiceService(InvoiceService invoiceService) {
        ServiceFactory.invoiceService = invoiceService;
    }

}
