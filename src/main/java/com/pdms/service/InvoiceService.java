/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;


import com.pdms.display.InvoiceDisplay;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface InvoiceService {
    void insert(InvoiceDisplay invoiceDisplay) throws Exception;  
    List<InvoiceDisplay> getAll(int customerId) throws Exception;
    InvoiceDisplay getInvoiceDisplay(int invoiceId) throws Exception;    
}
