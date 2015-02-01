/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view;

import com.pdms.domain.Customer;
import com.pdms.utils.Utils;
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

    private int id;
    private String name;
    private String address;
    private String pincode;
    private String mobileNo;
    private String stdCode;
    private String landline;
    private String amountBalance;
    private boolean status;

    public CustomerDisplay() {
    }

    public CustomerDisplay(int id, String name, String address, String pincode, String mobileNo, String stdCode, String landline, String amountBalance, boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.stdCode = stdCode;
        this.landline = landline;
        this.status = status;
        this.amountBalance = amountBalance;
    }

    public CustomerDisplay(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.pincode = customer.getPincode();
        this.mobileNo = customer.getMobileNo();
        this.stdCode = customer.getStdCode();
        this.landline = customer.getLandline();
        this.amountBalance = Utils.getDoubleValueAsMoney(customer.getAmountBalance());
        this.status = customer.isStatus();
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

    public String getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(String amountBalance) {
        this.amountBalance = amountBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
