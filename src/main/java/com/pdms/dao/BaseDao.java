/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
/**
 *
 * @author Suresh
 */
@Component
public abstract class BaseDao {
    public Logger logger = Logger.getLogger(BaseDao.class);
    protected HibernateTemplate hibernateTemplate;
    protected Class entityClass;
    
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    


    public <T> void insert(T obj) throws Exception{        
        hibernateTemplate.save(obj);   
        
    }
   
    public void flush(){
        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.flush();        
    }
}
