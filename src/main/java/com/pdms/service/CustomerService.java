/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.domain.Customer;
import com.pdms.utils.RequestParam;
import com.pdms.view.CustomerDisplay;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Suresh
 */
public interface CustomerService {
    void insert(CustomerDisplay customerDisplay) throws Exception;
    List<CustomerDisplay> getAll() throws Exception;
    CustomerDisplay getCustomerDisplay(CustomerDisplay customerDisplay) throws Exception;    
    void delete(CustomerDisplay customerDisplay) throws Exception;
    void update(CustomerDisplay customerDisplay) throws Exception;
}
