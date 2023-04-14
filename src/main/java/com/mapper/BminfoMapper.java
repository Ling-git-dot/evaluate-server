package com.mapper;

import com.model.Bminfo;

import java.util.List;
import java.util.Map;

public interface BminfoMapper {
    /**
     * 查询所有部门信息
     *
     * @return
     */
    public List<Bminfo> query(Map<String, Object> inputParam);

    /**
     * 查询部门信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存部门信息
     *
     * @param bminfo
     * @return
     */
    public int insertBminfo(Bminfo bminfo);

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    public int deleteBminfo(int id);

    /**
     * 更新部门信息
     *
     * @param bminfo
     * @return
     */
    public int updateBminfo(Bminfo bminfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bminfo queryBminfoById(int id);
}
