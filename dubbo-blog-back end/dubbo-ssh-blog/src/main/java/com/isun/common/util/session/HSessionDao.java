package com.isun.common.util.session;

import com.isun.common.util.base.BaseHibernateDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HSessionDao extends BaseHibernateDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getHSession(){
        return sessionFactory.getCurrentSession();
    }
    public void close(){
        if(getHSession() != null) {
            getHSession().close();
        }
    }
    public void clear(){
        getHSession().clear();
    }
    public void flush(){
        getHSession().flush();
    }
    public List<Map<Object,Object>> sqlSelect(String sql) {
        List list = new ArrayList();
        Map<Object,Object> map = new HashMap<Object,Object>();

        return list;
    }


}
