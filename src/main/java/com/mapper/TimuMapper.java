package com.mapper;

import com.model.Timu;

import java.util.List;
import java.util.Map;

public interface TimuMapper {
    /**
     * 查询所有题目信息
     *
     * @return
     */
    public List<Timu> query(Map<String, Object> inputParam);

    /**
     * 查询题目信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存题目信息
     *
     * @param timu
     * @return
     */
    public int insertTimu(Timu timu);

    /**
     * 删除题目信息
     *
     * @param id
     * @return
     */
    public int deleteTimu(int id);

    /**
     * 更新题目信息
     *
     * @param timu
     * @return
     */
    public int updateTimu(Timu timu);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Timu queryTimuById(int id);
}
