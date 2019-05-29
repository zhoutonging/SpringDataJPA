package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 根据ID查询某一条类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过CategoryType查询类目
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增更新类目
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
