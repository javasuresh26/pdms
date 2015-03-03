/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.dao;

import com.pdms.dao.utils.RequestParam;
import com.pdms.domain.Customer;
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

        List<Map<String, Object>> criterias = requestParam.getCriterias();
        for (Map<String, Object> criteria : criterias) {
            String property;
            String expression = String.valueOf(criteria.get("expression"));
            switch (expression) {
                case "eq":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.eq(property, criteria.get("value")));
                    break;
                case "gt":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.gt(property, criteria.get("value")));
                    break;
                case "ge":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.ge(property, criteria.get("value")));
                    break;
                case "lt":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.lt(property, criteria.get("value")));
                    break;
                case "le":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.le(property, criteria.get("value")));
                    break;
                case "isNull":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.isNull(property));
                    break;
                case "isNotNull":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.isNotNull(property));
                    break;
                case "like":
                    property = String.valueOf(criteria.get("property"));
                    detachedCriteria.add(Restrictions.like(property, criteria.get("value")));
                    break;
                case "between":
                    property = String.valueOf(criteria.get("property"));
                    List betweenList = (List) criteria.get("values");
                    detachedCriteria.add(Restrictions.between(property, betweenList.get(0), betweenList.get(1)));
                    break;
                case "orderBy":
                    property = String.valueOf(criteria.get("property"));
                    String value = String.valueOf(criteria.get("value"));
                    switch (value) {
                        case "asc":
                            detachedCriteria.addOrder(Order.asc(property));
                            break;
                        case "desc":
                            detachedCriteria.addOrder(Order.desc(property));
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
