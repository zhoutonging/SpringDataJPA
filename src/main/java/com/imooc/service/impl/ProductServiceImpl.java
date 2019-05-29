package com.imooc.service.impl;

import com.imooc.dao.ProductInfoDao;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public void increasStock(List<CartDTO> cartDTOList) {
        return ;
    }

    @Override
    @Transactional
    public void decreasStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo =  productInfoDao.findById(cartDTO.getProductId()).get();
                if (productInfo==null){
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                }
                Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();

                if(result<0){
                    throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
                }

                productInfo.setProductStock(result);

                productInfoDao.save(productInfo);
        }
    }
}
