package com.imooc.dao;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao  extends JpaRepository<OrderDetail,String> {

    /**
     * 根据orderId查询订单商品
     * @param orderId 订单Id
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);

}
