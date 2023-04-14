package com.model;

import java.util.List;

/**
 * 统计实体
 */
public class Report {
    private List<String> names;
    private List<Integer> nums;
    private List<Xsksitem> datas;

    public List<Xsksitem> getDatas() {
        return datas;
    }

    public void setDatas(List<Xsksitem> datas) {
        this.datas = datas;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }
}
