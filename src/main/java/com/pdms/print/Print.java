/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.print;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Suresh
 */
public class Print {
    public static void print(Map<String,Object> parameters, List beanList, InputStream jsperReports,String location) throws JRException{
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(beanList);
        JasperDesign jasperDesign = JRXmlLoader.load(jsperReports);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "c:/temp/test_jasper.pdf");
    }
    
    public static InputStream getInputStream(String jasperFileName){
        return ClassLoader.getSystemResourceAsStream(jasperFileName);
    }
}
