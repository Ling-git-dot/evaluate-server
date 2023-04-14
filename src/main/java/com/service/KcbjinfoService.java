package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Kcbjinfo;

/**
 * 课程班级信息Service接口
 */
public interface KcbjinfoService {
    /**
     * 查询课程班级信息记录数
     *
     * @param kcbjinfo
     * @return
     */
    public int getCount(Kcbjinfo kcbjinfo);

    /**
     * 查询所有课程班级信息
     *
     * @return
     */
    public List<Kcbjinfo> queryKcbjinfoList(Kcbjinfo kcbjinfo, PageBean page) throws Exception;

    /**
     * 保存课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int insertKcbjinfo(Kcbjinfo kcbjinfo) throws Exception;

    /**
     * 删除课程班级信息
     *
     * @param id
     * @return
     */
    public int deleteKcbjinfo(int id) throws Exception;

    /**
     * 更新课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int updateKcbjinfo(Kcbjinfo kcbjinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcbjinfo queryKcbjinfoById(int id) throws Exception;
}
