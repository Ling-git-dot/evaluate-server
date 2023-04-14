package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息Model类
 */
public class Userinfo {
    public Userinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 学号/工号
     */
    private String sno;
    /**
     * 密码
     */
    private String upwd;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 电话
     */
    private String tel;
    /**
     * 班级
     */
    private Integer bid;
    /**
     * 用户类型
     */
    private String utype;
    private Bjinfo bjinfoVO;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return this.sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getUpwd() {
        return this.upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUtype() {
        return this.utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public Bjinfo getBjinfoVO() {
        return this.bjinfoVO;
    }

    public void setBjinfoVO(Bjinfo bjinfoVO) {
        this.bjinfoVO = bjinfoVO;
    }


}
