/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.main;

import com.pdms.frame.MainWindow;
import com.pdms.service.CustomerServiceImpl;
import com.pdms.service.InvoiceServiceImpl;
import javax.swing.UIManager;
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
    
    public static void main(String args[]) throws Exception {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //new MainWindowFrame();
        //CustomerDaoImpl sss = new CustomerDaoImpl();
        //Customer obj = new Customer();
        //System.out.println(obj);
        //sss.insert(obj);
        //System.out.println(obj);
        //System.out.println(ClassLoader.getSystemResource(""));
//        Customer customer = new Customer();
//        customer.setId(18);        
//        csi.delete(customer);
//        
//        List<Customer> customers = csi.getAll();
//        for (Customer customer : customers) {
//            System.out.println(customer);
//        }
//        Customer customer = customers.get(0);
//
//        customer.setId(19);        
//        csi.update(customer);
//        Customer customer  = new Customer();
//        customer.setId(19);
//        customer.setLandline("04177");
        //csi.merge(customer);
        //System.out.println(csi.getByCriteria("sd%"));
        // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        InvoiceServiceImpl invoiceServiceImpl = context.getBean(InvoiceServiceImpl.class);
        
        MainWindow mainWindow = new MainWindow(context);    
    
    
    
    }
    
}
