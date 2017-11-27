package com.isun.service.impl;

import java.util.List;

import com.isun.common.util.base.BaseHibernateDao;
import com.isun.common.util.session.HSessionDao;
import com.isun.dao.UserDao;
import com.isun.entity.AcctUser;
import com.isun.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends HSessionDao implements IUserService {

    /**
     * 注意：HibernateTemplate和HibernateOperations都是spring-orm的类
     * HibernateTemplate无法用@Autowired注入，因为不是他接口，若用SessionFactory则可以注入
     * 若你非要用@Autowired，我尝试了用HibernateTemplate的接口类HibernateOperations注入结果还是失败
     * 经过多番的推敲、发现hibernacle core jar中有HibernateDaoSupport时依赖spring-orm的HibernateTemple开发的
     * 也就是我们 可以直接用HibernateDaoSupport满足需求
     */
//    private HibernateTemplate hibernateTemplate;


    public AcctUser load(String id) {
        return (AcctUser)getHSession().load(AcctUser.class,id);
    }

    public AcctUser get(String id) {
        return (AcctUser) getHSession().get(AcctUser.class,id);
    }

    public void delete(String id) {
        getHSession().delete(id);
    }

    public void flush() { getHSession().flush(); }

}

