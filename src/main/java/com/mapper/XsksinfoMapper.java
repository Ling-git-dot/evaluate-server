package com.mapper;

import com.model.Xsksinfo;

import java.util.List;
import java.util.Map;

public interface XsksinfoMapper {
    /**
     * 查询所有用户问卷信息
     *
     * @return
     */
    public List<Xsksinfo> query(Map<String, Object> inputParam);

    /**
     * 查询用户问卷信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int insertXsksinfo(Xsksinfo xsksinfo);

    /**
     * 删除用户问卷信息
     *
     * @param id
     * @return
     */
    public int deleteXsksinfo(int id);

    /**
     * 更新用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int updateXsksinfo(Xsksinfo xsksinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksinfo queryXsksinfoById(int id);
}
