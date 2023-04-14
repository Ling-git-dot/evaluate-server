package com.model;

/**
 * 题目信息Model类
 */
public class Timu {
    public Timu() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 题目类型
     */
    private Integer ctype;
    /**
     * 题干
     */
    private String title;
    /**
     * 选项A
     */
    private String xxa;
    /**
     * 选项B
     */
    private String xxb;
    /**
     * 选项C
     */
    private String xxc;
    /**
     * 选项D
     */
    private String xxd;

    /**
     * 问卷
     */
    private Integer dtid;



    private Integer anums;
    private Integer bnums;
    private Integer cnums;
    private Integer dnums;

    public Integer getAnums() {
        return anums;
    }

    public void setAnums(Integer anums) {
        this.anums = anums;
    }

    public Integer getBnums() {
        return bnums;
    }

    public void setBnums(Integer bnums) {
        this.bnums = bnums;
    }

    public Integer getCnums() {
        return cnums;
    }

    public void setCnums(Integer cnums) {
        this.cnums = cnums;
    }

    public Integer getDnums() {
        return dnums;
    }

    public void setDnums(Integer dnums) {
        this.dnums = dnums;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCtype() {
        return this.ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXxa() {
        return this.xxa;
    }

    public void setXxa(String xxa) {
        this.xxa = xxa;
    }

    public String getXxb() {
        return this.xxb;
    }

    public void setXxb(String xxb) {
        this.xxb = xxb;
    }

    public String getXxc() {
        return this.xxc;
    }

    public void setXxc(String xxc) {
        this.xxc = xxc;
    }

    public String getXxd() {
        return this.xxd;
    }

    public void setXxd(String xxd) {
        this.xxd = xxd;
    }

    public Integer getDtid() {
        return this.dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }


}
