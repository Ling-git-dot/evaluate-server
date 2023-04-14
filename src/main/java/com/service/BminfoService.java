package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Bminfo;

/**
 * 部门信息Service接口
 */
public interface BminfoService {
    /**
     * 查询部门信息记录数
     *
     * @param bminfo
     * @return
     */
    public int getCount(Bminfo bminfo);

    /**
     * 查询所有部门信息
     *
     * @return
     */
    public List<Bminfo> queryBminfoList(Bminfo bminfo, PageBean page) throws Exception;

    /**
     * 保存部门信息
     *
     * @param bminfo
     * @return
     */
    public int insertBminfo(Bminfo bminfo) throws Exception;

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    public int deleteBminfo(int id) throws Exception;

    /**
     * 更新部门信息
     *
     * @param bminfo
     * @return
     */
    public int updateBminfo(Bminfo bminfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bminfo queryBminfoById(int id) throws Exception;
}
