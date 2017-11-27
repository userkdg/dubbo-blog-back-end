package com.isun.common.util.cfg;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.Serializable;

/**
 * 不需要了在hibernate4中在spring-hibernate.xml中配置了sessionFactory、只要在dao层直接@autowired接口信息即可
 */
@Deprecated
public class Hibernate4Utils {

    private static SessionFactory sessionFactory;

    private Hibernate4Utils() {
    }

    static {
        /**
         * configure()参数为空默认查找classes目录下hibernate.cfg.xml
         * configure("文件名")也有重载方法，参数名为配置文件名
         */
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 如果想使用sessionFactory.getCurrentSession()来获得Session时，需要在配置文件中添加一句：
     * 《《本地事务 防止使用sessionFactory.getCurrentSession()时报错："org.hibernate.HibernateException: No CurrentSessionContext configured!"》》
     * <property name="hibernate.current_session_context_class">thread</property>
     * @return
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public static Session getNewSession() {
        return sessionFactory.openSession();
    }
    public static void add(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernate4Utils.getNewSession();
            tx = s.beginTransaction();
            s.save(entity);
            tx.commit();
        } finally {
            if (s != null)
                s.close();
        }
    }

    public static void update(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernate4Utils.getNewSession();
            tx = s.beginTransaction();
            s.update(entity);
            tx.commit();
        } finally {
            if (s != null)
                s.close();
        }
    }

    public static void delete(Object entity) {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernate4Utils.getNewSession();
            tx = s.beginTransaction();
            s.delete(entity);
            tx.commit();
        } finally {
            if (s != null)
                s.close();
        }
    }

    public static Object get(Class clazz, Serializable id) {
        Session s = null;
        try {
            s = Hibernate4Utils.getNewSession();
            Object obj = s.get(clazz, id);
            return obj;
        } finally {
            if (s != null)
                s.close();
        }
    }
}