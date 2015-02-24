/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view;

import com.pdms.domain.Item;
import com.pdms.domain.ItemPrice;
import com.pdms.utils.Utils;
import java.util.Date;

/**
 *
 * @author Suresh
 */
public class ItemPriceDisplay {

    private int id;
    private int itemId;
    private Date startDate;
    private Date endDate;
    private String price;
    private Date modifiedDate;
    private String modifiedBy;

    public ItemPriceDisplay() {
    }

    public ItemPriceDisplay(ItemPrice itemPrice) {
        this.id = itemPrice.getId();
        this.itemId = itemPrice.getItem().getId();
        this.startDate = itemPrice.getStartDate();
        this.endDate = itemPrice.getEndDate();
        this.price = Utils.getDoubleValueAsMoney(itemPrice.getPrice());
        this.modifiedDate = itemPrice.getModifiedDate();
        this.modifiedBy = itemPrice.getModifiedBy();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
