package com.model;

/**
 * 课程信息Model类
 */
public class Kcinfo {
    public Kcinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 老师
     */
    private Integer tid;
    private Userinfo userinfoVO;
    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return this.tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Userinfo getUserinfoVO() {
        return this.userinfoVO;
    }

    public void setUserinfoVO(Userinfo userinfoVO) {
        this.userinfoVO = userinfoVO;
    }
}
