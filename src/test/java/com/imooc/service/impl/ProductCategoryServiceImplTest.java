package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceImpl;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryServiceImpl.findOne(1);
        System.out.print(productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryServiceImpl.findAll();
        for (ProductCategory productCategory : productCategoryList) {
            System.out.print(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,5);
        List<ProductCategory> productCategoryList = productCategoryServiceImpl.findByCategoryTypeIn(list);

        for (ProductCategory productCategory : productCategoryList) {
            System.out.print(productCategory);
        }
    }

    @Test
    public void save() {

    }
}