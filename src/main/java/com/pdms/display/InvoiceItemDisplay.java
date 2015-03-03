/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.display;

import com.pdms.domain.InvoiceItem;
import com.pdms.utils.Utils;

/**
 *
 * @author Suresh
 */
public class InvoiceItemDisplay {
    private int id; 
    private String name;
    private String type;
    private String quantity;
    private String unitPrice;
    private String total;

    public InvoiceItemDisplay() {
    }

    public void setItemDisplay(ItemDisplay itemDisplay,int quantity){
       
        this.name = itemDisplay.getName();
        this.quantity = String.valueOf(quantity);
        this.unitPrice = itemDisplay.getPrice();
        this.type = itemDisplay.getType().name();
        this.total = Utils.getDoubleValueAsMoney(quantity * Double.parseDouble(itemDisplay.getPrice()));
        
    }
    public InvoiceItemDisplay(InvoiceItem invoiceItem) {
        this.id = invoiceItem.getId();
        this.name = invoiceItem.getName();
        this.quantity = String.valueOf(invoiceItem.getQuantity());
        this.unitPrice = Utils.getDoubleValueAsMoney(invoiceItem.getUnitPrice());
        this.type = invoiceItem.getType();
        this.total = Utils.getDoubleValueAsMoney(invoiceItem.getQuantity() * invoiceItem.getUnitPrice());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "InvoiceItemDisplay{" + "id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", total=" + total + '}';
    }

    
    
    
    
}
