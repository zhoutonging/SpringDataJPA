package com.imooc.dao;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    /**
     * 按照买家的Openid分页查询订单
     *
     * @param buyerOpenid 微信授权唯一标识符
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
