/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view;

import com.pdms.domain.Customer;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Suresh
 */
public class CustomerDisplay {

    private long id;
    private String name;
    private String address;
    private String pincode;
    private String mobileNo;
    private String stdCode;
    private String landline;

    public CustomerDisplay() {
    }

    public CustomerDisplay(long id, String name, String address, String pincode, String mobileNo, String stdCode, String landline) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.stdCode = stdCode;
        this.landline = landline;
    }
    
    public CustomerDisplay(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.pincode = customer.getPincode();
        this.mobileNo = customer.getMobileNo();
        this.stdCode = customer.getStdCode();
        this.landline = customer.getLandline();
    }

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
}
