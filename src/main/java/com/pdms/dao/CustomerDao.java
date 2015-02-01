/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.Customer;
import com.pdms.utils.RequestParam;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface CustomerDao {
    void insert(Customer customer) throws Exception;
    void delete(Customer customer);
    List<Customer> getAll();
    void update(Customer customer);
    List<Customer> get(RequestParam requestParam);
}
