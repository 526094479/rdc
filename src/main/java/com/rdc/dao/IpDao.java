package com.rdc.dao;

import com.rdc.entity.IpMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IpDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public IpMap getIpMap(String ip){
        String sql = "FROM IpMap WHERE ip = :ip";
        IpMap ipMap = (IpMap) getSession().createQuery(sql).setString("ip",ip).uniqueResult();
        return ipMap;
    }

    public void save(IpMap ipMap){
        getSession().save(ipMap);
    }

    public void update(IpMap ipMap) {
        getSession().update(ipMap);
    }
}
