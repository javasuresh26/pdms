/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.display.CustomerDisplay;
import com.pdms.domain.Customer;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface CustomerService {
    void insert(CustomerDisplay customerDisplay) throws Exception;
    List<CustomerDisplay> getAll() throws Exception;
    List<CustomerDisplay> getValidAll() throws Exception;
    CustomerDisplay getCustomerDisplay(int id) throws Exception;    
    void delete(CustomerDisplay customerDisplay) throws Exception;
    void update(CustomerDisplay customerDisplay) throws Exception;
    Customer getCustomer(int id);
}
