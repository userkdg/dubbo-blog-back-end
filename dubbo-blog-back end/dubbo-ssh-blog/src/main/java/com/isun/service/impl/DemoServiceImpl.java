package com.isun.service.impl;

import com.isun.common.util.session.HSessionDao;
import com.isun.entity.AcctUser;
import com.isun.service.IDemoService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl extends HSessionDao implements IDemoService{

    public List<AcctUser> getUserList(){
        Criteria criteria = getHSession().createCriteria(AcctUser.class, "u")
                .add(Restrictions.between("id", "2", "8"))
                .add(Restrictions.idEq("3"))
                .addOrder(Order.desc("nickName"));
        return criteria.list();
    }
    public List getListBySql(){
        String sql = "select * from acct_user";
        List<Map<Object, Object>> list = sqlSelect(sql);
        return list;
    }
}
