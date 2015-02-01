/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.domain;

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
//@Entity
//@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    @Length(max = 50)
    private String name;

    @Column(name = "mobileno", nullable = false,length = 10)
    private String mobileNo;

    @Column(name = "createdDate", nullable = false, columnDefinition = "DATETIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = false, columnDefinition = "DATETIME")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    public java.util.Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(java.util.Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        return "Employee{" + "id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status + '}';
    }
}
