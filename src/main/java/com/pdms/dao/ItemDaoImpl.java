/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Item;
import com.pdms.domain.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh
 */
@Repository
public class ItemDaoImpl extends BaseDao implements ItemDao{

    @Autowired
    public void setEntityClass() {
        super.entityClass = Item.class;
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(Item item) throws Exception {
        super.insert(item);
    }

    @Override
    @Transactional
    public List<Item> getAll() {
        return (List<Item>) super.getAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Item item) {
        super.delete(item);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Item item) {
        super.update(item);
    }

    @Override
    @Transactional
    public List<Item> get(RequestParam requestParam) {
        return (List<Item>) super.get(requestParam);
    }
    
}
