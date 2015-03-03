/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.display;

import com.pdms.domain.Invoice;
import com.pdms.domain.InvoiceItem;
import com.pdms.utils.DateUtils;
import com.pdms.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suresh
 */
public class InvoiceDisplay {

    private int id;
    private int customerId;
    private CustomerDisplay customerDisplay;
    private String dog;
    private String fromDate;
    private String toDate;
    private String payableAmount;
    private String totalAmount;
    private String discount;
    private List<InvoiceItemDisplay> invoiceItemDisplays;
    public InvoiceDisplay() {
    }

    public InvoiceDisplay(Invoice invoice) {
        this.id = invoice.getId();
        this.customerId = invoice.getCustomer().getId();
        this.dog = DateUtils.getDateAsString(invoice.getDog());
        this.fromDate = DateUtils.getDateAsString(invoice.getFromDate());
        this.toDate = DateUtils.getDateAsString(invoice.getToDate());
        this.payableAmount = Utils.getDoubleValueAsMoney(invoice.getPayableAmount());
        this.totalAmount = Utils.getDoubleValueAsMoney(invoice.getTotalAmount());
        this.discount = Utils.getDoubleValueAsMoney(invoice.getDiscount());
        this.customerDisplay = new CustomerDisplay(invoice.getCustomer());
        this.invoiceItemDisplays = getInvoiceItemDisplays(invoice.getInvoiceItems());
    }

    private List<InvoiceItemDisplay> getInvoiceItemDisplays(List<InvoiceItem> invoiceItems){
        List<InvoiceItemDisplay> itemDisplays = new ArrayList<>();
        for(InvoiceItem invoiceItem: invoiceItems){
            itemDisplays.add(new InvoiceItemDisplay(invoiceItem));
        }
        return itemDisplays;
    }
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerDisplay getCustomerDisplay() {
        return customerDisplay;
    }

    public void setCustomerDisplay(CustomerDisplay customerDisplay) {
        this.customerDisplay = customerDisplay;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public List<InvoiceItemDisplay> getInvoiceItemDisplays() {
        return invoiceItemDisplays;
    }

    public void setInvoiceItemDisplays(List<InvoiceItemDisplay> invoiceItemDisplays) {
        this.invoiceItemDisplays = invoiceItemDisplays;
    }

    @Override
    public String toString() {
        return "InvoiceDisplay{" + "id=" + id + ", customerId=" + customerId + ", customerDisplay=" + customerDisplay + ", dog=" + dog + ", fromDate=" + fromDate + ", toDate=" + toDate + ", payableAmount=" + payableAmount + ", totalAmount=" + totalAmount + ", discount=" + discount + ", invoiceItemDisplays=" + invoiceItemDisplays + '}';
    }

   


}
