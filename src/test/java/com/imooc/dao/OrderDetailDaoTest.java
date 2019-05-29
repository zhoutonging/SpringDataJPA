package com.imooc.dao;

import com.imooc.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1122");
        orderDetail.setProductName("牙膏");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());

        orderDetailDao.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("111");
        for (OrderDetail orderDetail : orderDetailList){
            System.out.println(orderDetail);
        }
    }
}