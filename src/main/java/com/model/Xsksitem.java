package com.model;

import java.util.List;

/**
 * 问卷明细Model类
 */
public class Xsksitem {
    public Xsksitem() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 用户问卷信息
     */
    private Integer xsksid;
    /**
     * 题目
     */
    private Integer tmid;
    /**
     * 答案
     */
    private String da;

    private Xsksinfo xsksinfoVO;
    private Timu timuVO;
    private Integer ctype;
    private Integer ksid;

    public Integer getKsid() {
        return ksid;
    }

    public void setKsid(Integer ksid) {
        this.ksid = ksid;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXsksid() {
        return this.xsksid;
    }

    public void setXsksid(Integer xsksid) {
        this.xsksid = xsksid;
    }

    public Integer getTmid() {
        return this.tmid;
    }

    public void setTmid(Integer tmid) {
        this.tmid = tmid;
    }

    public String getDa() {
        return this.da;
    }

    public void setDa(String da) {
        this.da = da;
    }


    public Xsksinfo getXsksinfoVO() {
        return this.xsksinfoVO;
    }

    public void setXsksinfoVO(Xsksinfo xsksinfoVO) {
        this.xsksinfoVO = xsksinfoVO;
    }

    public Timu getTimuVO() {
        return this.timuVO;
    }

    public void setTimuVO(Timu timuVO) {
        this.timuVO = timuVO;
    }
}
