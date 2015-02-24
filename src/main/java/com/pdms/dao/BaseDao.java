/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.dao.utils.RequestParam.CriteriaParam;
import com.pdms.utils.Utils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Suresh
 */
@Component
public abstract class BaseDao {

    public Logger logger = Logger.getLogger(BaseDao.class);
    protected HibernateTemplate hibernateTemplate;
    protected Class entityClass;
    private Utils utils;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Autowired
    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    protected <T> void insert(T obj) throws Exception {
        hibernateTemplate.save(obj);

    }

    protected List getAll() {
        DetachedCriteria criteria = utils.createCriteria(entityClass);
        return hibernateTemplate.findByCriteria(criteria);
    }

    protected <T> void update(T obj) {
        hibernateTemplate.update(obj);
    }

    protected <T> void saveOrUpdate(T obj) {
        hibernateTemplate.saveOrUpdate(obj);
    }

    protected <T> void delete(T obj) {
        hibernateTemplate.delete(obj);
    }

    protected <T> void merge(T obj) {
        hibernateTemplate.merge(obj);

    }
    
    protected List get(RequestParam requestParam) {  
        DetachedCriteria detachedCriteria = createCriteria(requestParam);
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }
    protected List get(RequestParam requestParam, int firstResult, int maxResults) {
        DetachedCriteria detachedCriteria = createCriteria(requestParam);
        return hibernateTemplate.findByCriteria(detachedCriteria, firstResult, maxResults);
    }
    
    protected DetachedCriteria createCriteria(RequestParam requestParam) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);

        Set<Entry<String, CriteriaParam>> criterias = requestParam.getCriterias().entrySet();
        for (Entry<String, CriteriaParam> entry : criterias) {
            CriteriaParam criteria = entry.getValue();
            switch (entry.getKey()) {
                case "eq":
                    detachedCriteria.add(Restrictions.eq(criteria.getPropery(), criteria.getValue()));
                    break;
                case "gt":
                    detachedCriteria.add(Restrictions.gt(criteria.getPropery(), criteria.getValue()));
                    break;
                case "ge":
                    detachedCriteria.add(Restrictions.ge(criteria.getPropery(), criteria.getValue()));
                    break;
                case "lt":
                    detachedCriteria.add(Restrictions.lt(criteria.getPropery(), criteria.getValue()));
                    break;
                case "le":
                    detachedCriteria.add(Restrictions.le(criteria.getPropery(), criteria.getValue()));
                    break;
                case "isNull":
                    detachedCriteria.add(Restrictions.isNull(criteria.getPropery()));
                    break;
                case "isNotNull":
                    detachedCriteria.add(Restrictions.isNotNull(criteria.getPropery()));
                    break;
                case "like":
                    detachedCriteria.add(Restrictions.like(criteria.getPropery(), criteria.getValue()));
                    break;
                case "between":
                    List betweenList = (List) criteria.getValue();
                    detachedCriteria.add(Restrictions.between(criteria.getPropery(), betweenList.get(0), betweenList.get(1)));
                    break;
                case "orderBy":
                    String orderBy = String.valueOf(criteria.getValue());
                    switch (orderBy) {
                        case "asc":
                            detachedCriteria.addOrder(Order.asc(entry.getKey()));
                            break;
                        case "desc":
                            detachedCriteria.addOrder(Order.desc(entry.getKey()));
                            break;
                    }
                    break;
            }
        }
        return detachedCriteria;
    }


    protected void flush() {
        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.flush();
    }
}
