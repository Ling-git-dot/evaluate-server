package com.model;

/**
 * 班级信息Model类
 */
public class Bjinfo {
    public Bjinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 班级名称
     */
    private String name;

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
}
