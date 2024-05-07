package com.demo.portal.test.proxy4;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CardBizImpl implements CardBiz {
    @Resource(name = "cardDaoImpl")
    private CardDao cardDao;

    @Override
    public boolean reCharge() {
        if(cardDao.save()>0){
            System.out.println("充值成功");
            return true;
        }
        System.out.println("充值失败");
        return false;
    }
}
