package com.rdc.service;

import com.rdc.dao.IpDao;
import com.rdc.entity.IpMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IpService {
    @Autowired
    private IpDao ipDao;

    @Transactional
    public Boolean countTimes(String ip){
        IpMap ipMap = ipDao.getIpMap(ip);
        if(ipMap == null){
            ipMap = new IpMap(ip,1);
//            ipDao.save(ipMap);
            return true;
        }else if(ipMap.getCount()>=5) {
            return false;
        }else {
            ipMap.setCount(ipMap.getCount()+1);
            ipDao.update(ipMap);
            return true;
        }
    }
}
