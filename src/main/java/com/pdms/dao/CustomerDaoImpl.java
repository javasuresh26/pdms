/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Suresh
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao{
    
    
    public void setEntityClass() {
        this.entityClass = Customer.class;
    }    

    @Override
    public void insert(Customer customer) throws Exception{
        super.insert(customer);
    }
}
