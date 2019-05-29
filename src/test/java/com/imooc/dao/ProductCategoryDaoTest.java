package com.imooc.dao;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory =  productCategoryDao.findById(1).get();
        System.out.print(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory =  productCategoryDao.findById(2).get();
        productCategory.setCategoryName("怪兽的最爱");
        productCategory.setCategoryType(4);
        productCategory.setUpdateTime(new Date());
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<ProductCategory> productCategorieList =  productCategoryDao.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,productCategorieList);

        for (ProductCategory productCategory:productCategorieList) {
            System.out.print(productCategory);
        }
    }
}