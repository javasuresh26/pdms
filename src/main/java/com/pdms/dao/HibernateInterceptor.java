/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.BaseEntity;
import com.pdms.domain.User;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.EmptyInterceptor;

/**
 *
 * @author Suresh
 */
public class HibernateInterceptor extends EmptyInterceptor {

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, org.hibernate.type.Type[] types) {
        super.onDelete(entity, id, state, propertyNames, types); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, org.hibernate.type.Type[] types) {
        setValue(currentState, propertyNames, "modifiedDate", new Date());
        setValue(currentState, propertyNames, "modifiedBy", User.getCurrentUserName());
        return true;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, org.hibernate.type.Type[] types) {
        setValue(state, propertyNames, "createdDate", new Date());
        setValue(state, propertyNames, "modifiedDate", new Date());
        setValue(state, propertyNames, "createdBy", User.getCurrentUserName());
        setValue(state, propertyNames, "modifiedBy", User.getCurrentUserName());
        return true;
    }

    private void setValue(Object[] currentState, String[] propertyNames,
            String propertyToSet, Object value) {
        int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
        if (index >= 0) {
            currentState[index] = value;
        }

    }

}
