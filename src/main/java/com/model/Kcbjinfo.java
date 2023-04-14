package com.model;

/**
 * 课程班级信息Model类
 */
public class Kcbjinfo {
    public Kcbjinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 课程
     */
    private Integer kcid;
    /**
     * 班级
     */
    private Integer bjid;
    private Kcinfo kcinfoVO;
    private Bjinfo bjinfoVO;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKcid() {
        return this.kcid;
    }

    public void setKcid(Integer kcid) {
        this.kcid = kcid;
    }

    public Integer getBjid() {
        return this.bjid;
    }

    public void setBjid(Integer bjid) {
        this.bjid = bjid;
    }

    public Kcinfo getKcinfoVO() {
        return this.kcinfoVO;
    }

    public void setKcinfoVO(Kcinfo kcinfoVO) {
        this.kcinfoVO = kcinfoVO;
    }

    public Bjinfo getBjinfoVO() {
        return this.bjinfoVO;
    }

    public void setBjinfoVO(Bjinfo bjinfoVO) {
        this.bjinfoVO = bjinfoVO;
    }
}
