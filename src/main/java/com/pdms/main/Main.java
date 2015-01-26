/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.main;

import com.pdms.dao.CustomerDaoImpl;
import com.pdms.domain.Customer;
import com.pdms.frame.MainWindowFrame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
 *
 * @author Suresh
 */
@Component
public class Main {
    
    private String name;
    
    public static void main(String args[]) throws Exception{
       //Session session = HibernateUtil.getSessionFactory().openSession();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //new MainWindowFrame();
        //CustomerDaoImpl sss = new CustomerDaoImpl();
        //Customer obj = new Customer();
        //System.out.println(obj);
        //sss.insert(obj);
        //System.out.println(obj);
        //System.out.println(ClassLoader.getSystemResource(""));
        Main main = new Main();
        System.out.println("Display: "+main.getName());
    }
    
    @Value("${jdbc.username}")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
