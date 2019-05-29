package com.imooc.dataobject;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    private String id;

    private String userName;

    private String password;


    @CreationTimestamp
    private Date createTime;
}
