package com.mapper;

import com.model.Kcbjinfo;

import java.util.List;
import java.util.Map;

public interface KcbjinfoMapper {
    /**
     * 查询所有课程班级信息
     *
     * @return
     */
    public List<Kcbjinfo> query(Map<String, Object> inputParam);

    /**
     * 查询课程班级信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int insertKcbjinfo(Kcbjinfo kcbjinfo);

    /**
     * 删除课程班级信息
     *
     * @param id
     * @return
     */
    public int deleteKcbjinfo(int id);

    /**
     * 更新课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int updateKcbjinfo(Kcbjinfo kcbjinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcbjinfo queryKcbjinfoById(int id);
}
