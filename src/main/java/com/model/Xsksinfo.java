package com.model;

import java.util.List;

/**
 * 用户问卷信息Model类
 */
public class Xsksinfo {
    public Xsksinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 学生
     */
    private Integer sid;
    /**
     * 课程
     */
    private Integer ksid;

    public Kcinfo getKcinfoVO() {
        return kcinfoVO;
    }

    public void setKcinfoVO(Kcinfo kcinfoVO) {
        this.kcinfoVO = kcinfoVO;
    }

    private Kcinfo kcinfoVO;

    /**
     * 参与时间
     */
    private String cdate;
    private Userinfo userinfoVO;

    private Integer tid;

    private List<Xsksitem> zplist;

    public List<Xsksitem> getZplist() {
        return zplist;
    }

    public void setZplist(List<Xsksitem> zplist) {
        this.zplist = zplist;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getKsid() {
        return this.ksid;
    }

    public void setKsid(Integer ksid) {
        this.ksid = ksid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public Userinfo getUserinfoVO() {
        return this.userinfoVO;
    }

    public void setUserinfoVO(Userinfo userinfoVO) {
        this.userinfoVO = userinfoVO;
    }


}
