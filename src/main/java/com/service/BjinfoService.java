package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Bjinfo;

/**
 * 班级信息Service接口
 */
public interface BjinfoService {
    /**
     * 查询班级信息记录数
     *
     * @param bjinfo
     * @return
     */
    public int getCount(Bjinfo bjinfo);

    /**
     * 查询所有班级信息
     *
     * @return
     */
    public List<Bjinfo> queryBjinfoList(Bjinfo bjinfo, PageBean page) throws Exception;

    /**
     * 保存班级信息
     *
     * @param bjinfo
     * @return
     */
    public int insertBjinfo(Bjinfo bjinfo) throws Exception;

    /**
     * 删除班级信息
     *
     * @param id
     * @return
     */
    public int deleteBjinfo(int id) throws Exception;

    /**
     * 更新班级信息
     *
     * @param bjinfo
     * @return
     */
    public int updateBjinfo(Bjinfo bjinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bjinfo queryBjinfoById(int id) throws Exception;
}
