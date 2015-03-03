/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.dao.InvoiceDao;
import com.pdms.dao.utils.RequestParam;
import com.pdms.display.InvoiceDisplay;
import com.pdms.display.InvoiceItemDisplay;

import com.pdms.domain.Customer;
import com.pdms.domain.Invoice;
import com.pdms.domain.InvoiceItem;
import com.pdms.utils.DateUtils;
import com.pdms.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceDao invoiceDao;
    private CustomerService customerService;
    private Utils utils;

    @Autowired
    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    @Override
    public void insert(InvoiceDisplay invoiceDisplay) throws Exception {
        invoiceDao.insert(getInvoice(invoiceDisplay));
    }

    @Override
    public List<InvoiceDisplay> getAll(int customerId) throws Exception {
        RequestParam requestParam = new RequestParam();
        HashMap<String, Object> criteria = new HashMap<>();
        criteria.put("expression", "eq");
        criteria.put("property", "customer.id");
        criteria.put("value", customerId);
        requestParam.addCriteria(criteria);
        return getInvoiceDisplays(get(requestParam));
    }

    @Override
    //@Transactional
    public InvoiceDisplay getInvoiceDisplay(int invoiceId) throws Exception {
        RequestParam requestParam = new RequestParam();
        HashMap<String, Object> criteria = new HashMap<>();
        criteria.put("expression", "eq");
        criteria.put("property", "id");
        criteria.put("value", invoiceId);
        requestParam.addCriteria(criteria);
        return getInvoiceDisplay(get(requestParam).get(0));
    }

    private List<InvoiceDisplay> getInvoiceDisplays(List<Invoice> invoices) {
        List<InvoiceDisplay> invoiceDisplays = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceDisplays.add(new InvoiceDisplay(invoice));
        }
        return invoiceDisplays;
    }

    private InvoiceDisplay getInvoiceDisplay(Invoice invoice) {
        return new InvoiceDisplay(invoice);
    }

    private List<Invoice> get(RequestParam requetParam) {
        return invoiceDao.get(requetParam);
    }

    private Invoice getInvoice(InvoiceDisplay invoiceDisplay) throws Exception {
        Invoice invoice = utils.createInstance(Invoice.class);

        invoice.setId(invoiceDisplay.getId());
        invoice.setCustomer(getCustomer(invoiceDisplay.getCustomerDisplay().getId()));
        invoice.setDog(DateUtils.getDatefromString(invoiceDisplay.getDog()));
        invoice.setFromDate(DateUtils.getDatefromString(invoiceDisplay.getFromDate()));
        invoice.setToDate(DateUtils.getDatefromString(invoiceDisplay.getToDate()));
        invoice.setPayableAmount(Double.parseDouble(invoiceDisplay.getPayableAmount()));
        invoice.setTotalAmount(Double.parseDouble(invoiceDisplay.getTotalAmount()));
        invoice.setDiscount(Double.parseDouble(invoiceDisplay.getDiscount()));

        invoice.setInvoiceItems(getInvoiceItems(invoiceDisplay.getInvoiceItemDisplays(), invoice));
        return invoice;
    }

    private Customer getCustomer(int id) {
        return customerService.getCustomer(id);
    }

    private List<InvoiceItem> getInvoiceItems(List<InvoiceItemDisplay> itemDisplays, Invoice invoice) {
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (InvoiceItemDisplay itemDisplay : itemDisplays) {
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setInvoice(invoice);

            invoiceItem.setId(itemDisplay.getId());
            invoiceItem.setName(itemDisplay.getName());
            invoiceItem.setQuantity(Integer.parseInt(itemDisplay.getQuantity()));
            invoiceItem.setType(itemDisplay.getType());
            invoiceItem.setUnitPrice(Double.parseDouble(itemDisplay.getUnitPrice()));

            invoiceItems.add(invoiceItem);
        }
        return invoiceItems;
    }
}
