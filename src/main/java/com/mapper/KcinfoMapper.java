package com.mapper;

import com.model.Kcinfo;

import java.util.List;
import java.util.Map;

public interface KcinfoMapper {
    /**
     * 查询所有课程信息
     *
     * @return
     */
    public List<Kcinfo> query(Map<String, Object> inputParam);

    /**
     * 查询课程信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存课程信息
     *
     * @param kcinfo
     * @return
     */
    public int insertKcinfo(Kcinfo kcinfo);

    /**
     * 删除课程信息
     *
     * @param id
     * @return
     */
    public int deleteKcinfo(int id);

    /**
     * 更新课程信息
     *
     * @param kcinfo
     * @return
     */
    public int updateKcinfo(Kcinfo kcinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcinfo queryKcinfoById(int id);
}
