package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Kcinfo;

/**
 * 课程信息Service接口
 */
public interface KcinfoService {
    /**
     * 查询课程信息记录数
     *
     * @param kcinfo
     * @return
     */
    public int getCount(Kcinfo kcinfo);

    /**
     * 查询所有课程信息
     *
     * @return
     */
    public List<Kcinfo> queryKcinfoList(Kcinfo kcinfo, PageBean page) throws Exception;

    /**
     * 保存课程信息
     *
     * @param kcinfo
     * @return
     */
    public int insertKcinfo(Kcinfo kcinfo) throws Exception;

    /**
     * 删除课程信息
     *
     * @param id
     * @return
     */
    public int deleteKcinfo(int id) throws Exception;

    /**
     * 更新课程信息
     *
     * @param kcinfo
     * @return
     */
    public int updateKcinfo(Kcinfo kcinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcinfo queryKcinfoById(int id) throws Exception;
}
