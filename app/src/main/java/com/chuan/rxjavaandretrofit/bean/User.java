package com.chuan.rxjavaandretrofit.bean;

import com.chuan.rxjavaandretrofit.bean.base.BaseBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by chuan on 2017/3/13.
 */

@Entity
public class User extends BaseBean{
    @Id(autoincrement = true)
    private long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "PWD")
    private String password;
    @Generated(hash = 179890708)
    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
