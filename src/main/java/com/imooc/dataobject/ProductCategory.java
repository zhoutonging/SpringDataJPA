package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;//类目id
    private String categoryName;//类目名字
    private Integer categoryType;//类目编号
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType, Date createTime, Date updateTime) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
