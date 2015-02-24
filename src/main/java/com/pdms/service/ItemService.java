/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.domain.Item;
import com.pdms.view.CustomerDisplay;
import com.pdms.view.ItemDisplay;
import com.pdms.view.ItemPriceDisplay;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface ItemService {
    void insert(ItemDisplay itemDisplay) throws Exception;
    List<ItemDisplay> getAll() throws Exception;
    List<ItemDisplay> getValidAll() throws Exception;
    ItemDisplay getItemDisplay(int id) throws Exception;    
    void delete(ItemDisplay itemDisplay) throws Exception;
    void update(ItemDisplay itemDisplay) throws Exception;
    
    List<ItemPriceDisplay> getItemPriceDisplays(int itemId);
    
    
}
