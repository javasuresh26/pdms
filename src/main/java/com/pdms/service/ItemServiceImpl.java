/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.dao.ItemDao;
import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Item;
import com.pdms.domain.ItemPrice;
import com.pdms.utils.Utils;
import com.pdms.view.ItemDisplay;
import com.pdms.view.ItemPriceDisplay;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Suresh
 */
@Service
public class ItemServiceImpl implements ItemService {
    
    private ItemDao itemDao;
    private Utils utils;
    
    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
    
    @Autowired
    public void setUtils(Utils utils) {
        this.utils = utils;
    }
    
    @Override
    public void insert(ItemDisplay itemDisplay) throws Exception {
        itemDao.insert(getItem(itemDisplay));
    }
    
    @Override
    public List<ItemDisplay> getAll() {
        return getItemDisplays(itemDao.getAll());
    }
    
    @Override
    public List<ItemDisplay> getValidAll() {
        RequestParam requestParam = new RequestParam();
        RequestParam.CriteriaParam criteria = requestParam.createCriteria("status", true);
        requestParam.addCriteria("eq", criteria);
        return getItemDisplays(get(requestParam));
    }
    
    @Override
    public void delete(ItemDisplay itemDisplay) throws Exception {
        itemDao.delete(getItem(itemDisplay));
    }
    
    @Override
    public void update(ItemDisplay itemDisplay) {
        try {
            itemDao.update(getItem(itemDisplay));
        } catch (Exception ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<Item> get(RequestParam requetParam) {
        return itemDao.get(requetParam);
    }
    
    @Override
    public ItemDisplay getItemDisplay(int id) {
        RequestParam requestParam = new RequestParam();
        RequestParam.CriteriaParam criteria = requestParam.createCriteria("id", id);
        requestParam.addCriteria("eq", criteria);
        return getItemDisplays(get(requestParam)).get(0);
    }
    
    public List<Item> getByCriteria(int id) {
        RequestParam requestParam = new RequestParam();
        RequestParam.CriteriaParam criteria = requestParam.createCriteria("id", id);
        requestParam.addCriteria("eq", criteria);
        return get(requestParam);
    }
    
    private Item getItem(ItemDisplay itemDisplay) throws Exception {
        Item item = utils.createInstance(Item.class);
        item.setId(itemDisplay.getId());
        item.setActiveDays(itemDisplay.getActiveDays());
        item.setName(itemDisplay.getName());
        item.setType(itemDisplay.getType());
        item.setStatus(itemDisplay.isStatus());
        return item;
    }
    
    public List<ItemDisplay> getItemDisplays(List<Item> items) {
        List<ItemDisplay> itemDisplays = new ArrayList<>();
        for (Item item : items) {
            itemDisplays.add(new ItemDisplay(item));
            //System.out.println(item.getItemPrices());
        }
        return itemDisplays;
    }
    
    @Override
    public List<ItemPriceDisplay> getItemPriceDisplays(int itemId){
        Item item =getByCriteria(itemId).get(0);
        List<ItemPrice> itemPrices =item.getItemPrices();
        List<ItemPriceDisplay> itemPriceDisplays = new ArrayList<>();
        
        for(ItemPrice itemPrice: itemPrices){
            itemPriceDisplays.add(new ItemPriceDisplay(itemPrice));
        }
        
        return itemPriceDisplays;
    }
    
}
