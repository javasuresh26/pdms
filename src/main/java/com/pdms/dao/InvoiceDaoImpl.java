/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Invoice;
import com.pdms.domain.Invoice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Suresh
 */
@Repository
public class InvoiceDaoImpl extends BaseDao implements InvoiceDao{

    @Autowired
    public void setEntityClass() {
        super.entityClass = Invoice.class;
    }

    @Override
    @Transactional
    public void insert(Invoice invoice) throws Exception {
        super.insert(invoice);
    }

    @Override
    @Transactional
    public List<Invoice> getAll() {
        return (List<Invoice>) super.getAll();
    }   

    @Override
    @Transactional
    public List<Invoice> get(RequestParam requestParam) {
        return (List<Invoice>) super.get(requestParam);
    }
    
}
