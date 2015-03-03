/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Suresh
 */
public class RequestParam {

    //Map<String, CriteriaParam> criterias = new HashMap<>();
    List<Map<String, Object>> criterias = new ArrayList<>();

    public List<Map<String, Object>> getCriterias() {
        return criterias;
    }

    public void addCriteria(Map<String, Object> criteria) {
        criterias.add(criteria);
    }
    
}
