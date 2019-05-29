package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1539157225406301704";
    @Test
    public void cerate() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("周通");
        orderDTO.setBuyerAddress("江苏省徐州市铜山新区天赋广场10幢2011");
        orderDTO.setBuyerPhone("15052297681");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setCreateTime(new Date());
        orderDTO.setUpdateTime(new Date());

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1234");
        orderDetail.setProductQuantity(1);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result =  orderService.cerate(orderDTO);
        log.info("[创建订单] result = {}",result);

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO =  orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result={}",orderDTO);
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}