/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.main;

import com.pdms.dao.CustomerDaoImpl;
import com.pdms.domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author Suresh
 */
public class Main {
    public static void main(String args[]) throws Exception{
//        //Session session = HibernateUtil.getSessionFactory().openSession();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerDaoImpl sss = new CustomerDaoImpl();
//        Customer obj = new Customer();
//        //System.out.println(obj);
//        //sss.insert(obj);        
//	System.out.println(obj);
        System.out.println(ClassLoader.getSystemResource(""));
    }
}
