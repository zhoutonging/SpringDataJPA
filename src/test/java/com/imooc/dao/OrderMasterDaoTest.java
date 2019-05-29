package com.imooc.dao;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID="110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster =new OrderMaster();

        String UUID = java.util.UUID.randomUUID().toString();
        orderMaster.setOrderId(UUID);
        orderMaster.setBuyerName("CC");
        orderMaster.setBuyerPhone("15052297681");
        orderMaster.setBuyerAddress("江苏省无锡市");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result= orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpeniD(){
        PageRequest request = new PageRequest(0,1);

        Page<OrderMaster> result =  orderMasterDao.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

}