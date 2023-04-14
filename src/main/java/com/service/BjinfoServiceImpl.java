package com.service;

import java.util.List;

import com.model.Bjinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.BjinfoMapper;

/**
 * 班级信息Service实现类
 */
@Service
public class BjinfoServiceImpl implements BjinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private BjinfoMapper bjinfoMapper;

    /**
     * 查询班级信息记录数
     *
     * @param bjinfo
     * @return
     */
    public int getCount(Bjinfo bjinfo) {
        Map<String, Object> map = getQueryMap(bjinfo, null);
        return bjinfoMapper.getCount(map);
    }

    /**
     * 查询所有班级信息
     *
     * @return
     */
    public List<Bjinfo> queryBjinfoList(Bjinfo bjinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(bjinfo, page);
        List<Bjinfo> list = bjinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param bjinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Bjinfo bjinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bjinfo != null) {
            map.put("id", bjinfo.getId());
            map.put("name", bjinfo.getName());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存班级信息
     *
     * @param bjinfo
     * @return
     */
    public int insertBjinfo(Bjinfo bjinfo) throws Exception {
        return bjinfoMapper.insertBjinfo(bjinfo);
    }

    /**
     * 删除班级信息
     *
     * @param id
     * @return
     */
    public int deleteBjinfo(int id) throws Exception {
        return bjinfoMapper.deleteBjinfo(id);
    }

    /**
     * 更新班级信息
     *
     * @param bjinfo
     * @return
     */
    public int updateBjinfo(Bjinfo bjinfo) throws Exception {
        return bjinfoMapper.updateBjinfo(bjinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bjinfo queryBjinfoById(int id) throws Exception {
        return bjinfoMapper.queryBjinfoById(id);
    }
}
