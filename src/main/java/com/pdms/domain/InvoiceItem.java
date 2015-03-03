/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Suresh
 */
@Entity
@Table(name = "invoice_item")
public class InvoiceItem {
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "unit_price", nullable = false, scale = 2)
    private double unitPrice;
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    

    @Override
    public String toString() {
        return "InvoiceItem{" + "id=" + id + ", invoice=" + invoice + ", name=" + name + ", type=" + type + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }    
}
