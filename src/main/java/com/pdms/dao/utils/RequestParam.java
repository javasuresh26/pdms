/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Suresh
 */
public class RequestParam {

    Map<String, CriteriaParam> criterias = new HashMap<>();
    
    public void addCriteria(String propertyParam, CriteriaParam criteria){
        criterias.put(propertyParam, criteria);
    }

    public Map<String, CriteriaParam> getCriterias() {
        return criterias;
    }
    
    public CriteriaParam createCriteria(String propery, Object value){
       return new CriteriaParam(propery, value);
    } 
    
    public class CriteriaParam {
        String propery;
        Object value;
        
        public CriteriaParam(String propery, Object value){
            this.propery = propery;
            this.value = value;
        }

        public String getPropery() {
            return propery;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
        
    }

}
