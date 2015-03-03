/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import com.pdms.dao.CustomerDao;
import com.pdms.domain.Customer;
import com.pdms.dao.utils.RequestParam;
import com.pdms.utils.Utils;
import com.pdms.display.CustomerDisplay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private Utils utils;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    @Override    
    public void insert(CustomerDisplay customerDisplay) throws Exception {
        customerDao.insert(getCustomer(customerDisplay));
    }

    @Override    
    public List<CustomerDisplay> getAll() {
        return getCustomerDisplays(customerDao.getAll());
    }

    @Override    
    public List<CustomerDisplay> getValidAll() {
        RequestParam requestParam = new RequestParam();
        HashMap<String,Object> criteria =new HashMap<>();
        criteria.put("expression", "eq");
        criteria.put("property","status");
        criteria.put("value",true);
        requestParam.addCriteria(criteria);
        return getCustomerDisplays(get(requestParam));
    }

    @Override    
    public void delete(CustomerDisplay customerDisplay) throws Exception {
        customerDao.delete(getCustomer(customerDisplay));
    }

    @Override    
    public void update(CustomerDisplay customerDisplay) {
        try {
            customerDao.update(getCustomer(customerDisplay));
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<Customer> get(RequestParam requetParam) {
        return customerDao.get(requetParam);
    }

    @Override
    public CustomerDisplay getCustomerDisplay(int id) {
        return getCustomerDisplays(getByCriteria(id)).get(0);
    }

    @Override
    public Customer getCustomer(int id) {
        return getByCriteria(id).get(0);
    }
    
    public List<Customer> getByCriteria(int id) {
        RequestParam requestParam = new RequestParam();
        HashMap<String,Object> criteria =new HashMap<>();
        criteria.put("expression", "eq");
        criteria.put("property","id");
        criteria.put("value",id);
        requestParam.addCriteria(criteria);      
        return get(requestParam);
    }

    private Customer getCustomer(CustomerDisplay customerDisplay) throws Exception {
        Customer customer = utils.createInstance(Customer.class);
        customer.setId(customerDisplay.getId());
        customer.setAddress(customerDisplay.getAddress());
        customer.setStdCode(customerDisplay.getStdCode());
        customer.setLandline(customerDisplay.getLandline());
        customer.setMobileNo(customerDisplay.getMobileNo());
        customer.setName(customerDisplay.getName());
        customer.setPincode(customerDisplay.getPincode());
        customer.setStatus(customerDisplay.isStatus());
        return customer;
    }

    public List<CustomerDisplay> getCustomerDisplays(List<Customer> customers) {
        List<CustomerDisplay> customerDisplays = new ArrayList<>();
        for (Customer customer : customers) {
            customerDisplays.add(new CustomerDisplay(customer));
        }
        return customerDisplays;
    }

}
