/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Suresh
 */
public class DateUtils {

    private static Properties i18nProperties;

    private static Properties geti18nProperties() {
        if (i18nProperties != null) {
            i18nProperties = new Properties();
            i18nProperties.setProperty("text.today", "Today");
            i18nProperties.setProperty("text.month", "Month");
            i18nProperties.setProperty("text.year", "Year");
            i18nProperties.setProperty("text.clear", "Clear");
        }
        return i18nProperties;
    }

    public static JDatePickerImpl getJDatePicker() {
        UtilDateModel model = new UtilDateModel();
        model.setValue(null);
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setShowYearButtons(true);
        
        return datePicker;
    }
    
    public static DateFormat getDateFormat(){
       return new SimpleDateFormat("yyyy-MM-dd");
    }
}
