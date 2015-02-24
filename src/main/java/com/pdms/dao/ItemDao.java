/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Customer;
import com.pdms.domain.Item;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface ItemDao {
    void insert(Item item) throws Exception;
    void delete(Item item);
    List<Item> getAll();
    void update(Item item);
    List<Item> get(RequestParam requestParam);
}
