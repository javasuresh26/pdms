/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Invoice;
import java.util.List;

/**
 *
 * @author Suresh
 */
public interface InvoiceDao {
    void insert(Invoice invoice) throws Exception;
    List<Invoice> getAll();    
    List<Invoice> get(RequestParam requestParam);
}
