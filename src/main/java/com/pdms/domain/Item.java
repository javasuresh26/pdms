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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    @Length(max = 20)
    private String name;

    @Column(name = "type", columnDefinition = "enum('DAILYPAPER','MAGAZINE')")
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Column(name = "active_days", nullable = false)
    @Length(max = 20)
    private int activeDays;

    @Column(name = "created_date", nullable = false, columnDefinition = "DATETIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean status;

    @Column(name = "price", nullable = false, scale = 2)
    private double price;

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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(int activeDays) {
        this.activeDays = activeDays;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return "Item{" + "id=" + id + ", name=" + name + ", type=" + type + ", activeDays=" + activeDays + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status + ", price=" + price + '}';
    }

}
