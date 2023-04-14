package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Xsksitem;

/**
 * 问卷明细Service接口
 */
public interface XsksitemService {
    /**
     * 查询问卷明细记录数
     *
     * @param xsksitem
     * @return
     */
    public int getCount(Xsksitem xsksitem);

    /**
     * 查询所有问卷明细
     *
     * @return
     */
    public List<Xsksitem> queryXsksitemList(Xsksitem xsksitem, PageBean page) throws Exception;

    /**
     * 保存问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int insertXsksitem(Xsksitem xsksitem) throws Exception;

    /**
     * 删除问卷明细
     *
     * @param id
     * @return
     */
    public int deleteXsksitem(int id) throws Exception;

    /**
     * 更新问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int updateXsksitem(Xsksitem xsksitem) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksitem queryXsksitemById(int id) throws Exception;
}
