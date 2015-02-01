/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.Customer;
import com.pdms.utils.RequestParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh
 */
@Repository
//@Transactional
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Autowired
    public void setEntityClass() {
        super.entityClass = Customer.class;
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(Customer customer) throws Exception {
        super.insert(customer);
    }

    @Override
    @Transactional
    public List<Customer> getAll() {
        return (List<Customer>) super.getAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Customer customer) {
        super.delete(customer);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Customer customer) {
        super.update(customer);
    }

    @Override
    @Transactional
    public List<Customer> get(RequestParam requestParam) {
        return (List<Customer>) super.get(requestParam);
    }

}
