package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Xsksinfo;

/**
 * 用户问卷信息Service接口
 */
public interface XsksinfoService {
    /**
     * 查询用户问卷信息记录数
     *
     * @param xsksinfo
     * @return
     */
    public int getCount(Xsksinfo xsksinfo);

    /**
     * 查询所有用户问卷信息
     *
     * @return
     */
    public List<Xsksinfo> queryXsksinfoList(Xsksinfo xsksinfo, PageBean page) throws Exception;

    /**
     * 保存用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int insertXsksinfo(Xsksinfo xsksinfo) throws Exception;

    /**
     * 删除用户问卷信息
     *
     * @param id
     * @return
     */
    public int deleteXsksinfo(int id) throws Exception;

    /**
     * 更新用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int updateXsksinfo(Xsksinfo xsksinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksinfo queryXsksinfoById(int id) throws Exception;
}
