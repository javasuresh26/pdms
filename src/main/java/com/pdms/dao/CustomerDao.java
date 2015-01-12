/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.Customer;

/**
 *
 * @author Suresh
 */
public interface CustomerDao {
    public void insert(Customer customer) throws Exception;
}
