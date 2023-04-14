package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Timu;

/**
 * 题目信息Service接口
 */
public interface TimuService {
    /**
     * 查询题目信息记录数
     *
     * @param timu
     * @return
     */
    public int getCount(Timu timu);

    /**
     * 查询所有题目信息
     *
     * @return
     */
    public List<Timu> queryTimuList(Timu timu, PageBean page) throws Exception;

    /**
     * 保存题目信息
     *
     * @param timu
     * @return
     */
    public int insertTimu(Timu timu) throws Exception;

    /**
     * 删除题目信息
     *
     * @param id
     * @return
     */
    public int deleteTimu(int id) throws Exception;

    /**
     * 更新题目信息
     *
     * @param timu
     * @return
     */
    public int updateTimu(Timu timu) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Timu queryTimuById(int id) throws Exception;
}
