package com.mapper;

import com.model.Xsksitem;

import java.util.List;
import java.util.Map;

public interface XsksitemMapper {
    /**
     * 查询所有问卷明细
     *
     * @return
     */
    public List<Xsksitem> query(Map<String, Object> inputParam);

    /**
     * 查询问卷明细记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int insertXsksitem(Xsksitem xsksitem);

    /**
     * 删除问卷明细
     *
     * @param id
     * @return
     */
    public int deleteXsksitem(int id);

    /**
     * 更新问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int updateXsksitem(Xsksitem xsksitem);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksitem queryXsksitemById(int id);
}
