package com.isun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.isun.dao.UserDao;
import com.isun.entity.AcctUser;

/**
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    public AcctUser load(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        AcctUser user = (AcctUser)currentSession.get(AcctUser.class, id);
        return user;
    }

}
