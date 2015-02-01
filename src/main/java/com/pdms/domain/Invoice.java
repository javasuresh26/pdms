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

//@Entity
//@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue
    private long id;
    
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
    
    @Column(name = "amount", nullable = false, scale = 2)
    private double amount;
    
    @Column(name = "total_amount", nullable = false, scale = 2)
    private double totalAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
        return "Invoice{" + "id=" + id + ", customer=" + customer + ", dog=" + dog + ", fromDate=" + fromDate + ", toDate=" + toDate + ", amount=" + amount + ", totalAmount=" + totalAmount + '}';
    }
}
