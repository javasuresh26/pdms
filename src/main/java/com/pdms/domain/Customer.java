/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Suresh
 */

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    
    private long id;

    @Column(name = "name", nullable = false)
    @Length(max = 50)
    private String name;

    @Column(name = "address", nullable = false)
    @Length(max = 255)
    private String address;

    @Column(name = "pincode", nullable = false)
    @Length(max = 6)
    private String pincode;

    @Column(name = "mobileno", nullable = false)
    @Length(max = 10, min = 10)
    private String mobileNo;

    @Column(name = "stdCode")
    @Length(max = 6)
    private String stdCode;

    @Column(name = "landline")
    @Length(max = 10)
    private String landline;

    @Column(name = "amountBalance", nullable = false, scale = 2)
    private double amountBalance;

    @Column(name = "created_date", nullable = false, columnDefinition = "DATETIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = false, columnDefinition = "DATETIME")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "createdBy")
    @Length(max = 50)
    private String createdBy;

    @Column(name = "modifiedBy")
    @Length(max = 50)
    private String modifiedBy;
    
    @Column(name = "status", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean status;
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public double getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(double amountBalance) {
        this.amountBalance = amountBalance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", pincode=" + pincode + ", mobileNo=" + mobileNo + ", stdCode=" + stdCode + ", landline=" + landline + ", amountBalance=" + amountBalance + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", status=" + status + '}';
    }

}
