/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.domain.BaseEntity;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Iterator;
import org.hibernate.EmptyInterceptor;

/**
 *
 * @author Suresh
 */
public class HibernateInterceptor extends EmptyInterceptor {
    private int updates;
    private int creates;
    private int loads;

    public void onDelete(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        // do nothing
    }

    // This method is called when Employee object gets updated.
    public boolean onFlushDirty(Object entity,
            Serializable id,
            Object[] currentState,
            Object[] previousState,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof BaseEntity) {
            System.out.println("Update Operation");
            return true;
        }
        return false;
    }

    public boolean onLoad(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        // do nothing
        return true;
    }

    // This method is called when Employee object gets created.

    public boolean onSave(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
        if (entity instanceof BaseEntity) {
            System.out.println("Create Operation");
            return true;
        }
        return false;
    }

    //called before commit into database

    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }

    //called after committed into database

    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");
    }
}
