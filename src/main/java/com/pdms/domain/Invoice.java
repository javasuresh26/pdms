/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Suresh
 */
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "dog", nullable = false, columnDefinition = "DATETIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dog;

    @Column(name = "from_date", nullable = false, columnDefinition = "DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name = "to_date", nullable = false, columnDefinition = "DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name = "payable_amount", nullable = false, scale = 2)
    private double payableAmount;

    @Column(name = "total_amount", nullable = false, scale = 2)
    private double totalAmount;

    @Column(name = "discount", nullable = false, scale = 2)
    private double discount;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},mappedBy = "invoice")
    List<InvoiceItem> invoiceItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDog() {
        return dog;
    }

    public void setDog(Date dog) {
        this.dog = dog;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", customer=" + customer + ", dog=" + dog + ", fromDate=" + fromDate + ", toDate=" + toDate + ", payableAmount=" + payableAmount + ", totalAmount=" + totalAmount + '}';
    }
}
