package com.service;

import java.util.List;

import com.model.Timu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.TimuMapper;

/**
 * 题目信息Service实现类
 */
@Service
public class TimuServiceImpl implements TimuService {
    /**
     * 注入mapper
     */
    @Autowired
    private TimuMapper timuMapper;

    /**
     * 查询题目信息记录数
     *
     * @param timu
     * @return
     */
    public int getCount(Timu timu) {
        Map<String, Object> map = getQueryMap(timu, null);
        return timuMapper.getCount(map);
    }

    /**
     * 查询所有题目信息
     *
     * @return
     */
    public List<Timu> queryTimuList(Timu timu, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(timu, page);
        List<Timu> list = timuMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param timu
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Timu timu, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (timu != null) {
            map.put("id", timu.getId());
            map.put("ctype", timu.getCtype());
            map.put("dtid", timu.getDtid());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存题目信息
     *
     * @param timu
     * @return
     */
    public int insertTimu(Timu timu) throws Exception {
        return timuMapper.insertTimu(timu);
    }

    /**
     * 删除题目信息
     *
     * @param id
     * @return
     */
    public int deleteTimu(int id) throws Exception {
        return timuMapper.deleteTimu(id);
    }

    /**
     * 更新题目信息
     *
     * @param timu
     * @return
     */
    public int updateTimu(Timu timu) throws Exception {
        return timuMapper.updateTimu(timu);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Timu queryTimuById(int id) throws Exception {
        return timuMapper.queryTimuById(id);
    }
}
