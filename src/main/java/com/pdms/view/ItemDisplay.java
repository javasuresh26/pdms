/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view;

import com.pdms.domain.Item;
import com.pdms.domain.ItemType;

/**
 *
 * @author Suresh
 */
public class ItemDisplay {
    private int id;
    private String name;
    private ItemType type;
    private int activeDays;
    private boolean status;

    public ItemDisplay() {
    }

    public ItemDisplay(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.type = item.getType();
        this.activeDays = item.getActiveDays();
        this.status = item.isStatus();
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

  
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public static ItemType getItemType(String type){
        ItemType itemType = null;
        switch(type){
            case "DAILYPAPER":
                itemType = ItemType.DAILYPAPER;
                break;
            case "MAGAZINE":
                itemType = ItemType.MAGAZINE;
                break;             
        }
        return itemType;
    }

    @Override
    public String toString() {
        return "ItemDisplay{" + "id=" + id + ", name=" + name + ", type=" + type + ", activeDays=" + activeDays + ", status=" + status + '}';
    }
    
}
