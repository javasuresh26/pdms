/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Suresh
 */
public class RequestParam {

    Map<String, Criteria> criterias = new HashMap<>();
    
    public void addCriteria(String propertyParam, Criteria criteria){
        criterias.put(propertyParam, criteria);
    }

    public Map<String, Criteria> getCriterias() {
        return criterias;
    }
    
    public Criteria createCriteria(String propery, Object value){
       return new Criteria(propery, value);
    } 
    
    public class Criteria {
        String propery;
        Object value;
        
        public Criteria(String propery, Object value){
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
