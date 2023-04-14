package com.mapper;

import com.model.Bjinfo;

import java.util.List;
import java.util.Map;

public interface BjinfoMapper {
    /**
     * 查询所有班级信息
     *
     * @return
     */
    public List<Bjinfo> query(Map<String, Object> inputParam);

    /**
     * 查询班级信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存班级信息
     *
     * @param bjinfo
     * @return
     */
    public int insertBjinfo(Bjinfo bjinfo);

    /**
     * 删除班级信息
     *
     * @param id
     * @return
     */
    public int deleteBjinfo(int id);

    /**
     * 更新班级信息
     *
     * @param bjinfo
     * @return
     */
    public int updateBjinfo(Bjinfo bjinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bjinfo queryBjinfoById(int id);
}
