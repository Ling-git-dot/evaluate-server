package com.service;

import java.util.List;

import com.model.Kcinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.KcinfoMapper;

/**
 * 课程信息Service实现类
 */
@Service
public class KcinfoServiceImpl implements KcinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private KcinfoMapper kcinfoMapper;

    /**
     * 查询课程信息记录数
     *
     * @param kcinfo
     * @return
     */
    public int getCount(Kcinfo kcinfo) {
        Map<String, Object> map = getQueryMap(kcinfo, null);
        return kcinfoMapper.getCount(map);
    }

    /**
     * 查询所有课程信息
     *
     * @return
     */
    public List<Kcinfo> queryKcinfoList(Kcinfo kcinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(kcinfo, page);
        List<Kcinfo> list = kcinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param kcinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Kcinfo kcinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (kcinfo != null) {
            map.put("id", kcinfo.getId());
            map.put("name", kcinfo.getName());
            map.put("tid", kcinfo.getTid());
            map.put("bid", kcinfo.getBid());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存课程信息
     *
     * @param kcinfo
     * @return
     */
    public int insertKcinfo(Kcinfo kcinfo) throws Exception {
        return kcinfoMapper.insertKcinfo(kcinfo);
    }

    /**
     * 删除课程信息
     *
     * @param id
     * @return
     */
    public int deleteKcinfo(int id) throws Exception {
        return kcinfoMapper.deleteKcinfo(id);
    }

    /**
     * 更新课程信息
     *
     * @param kcinfo
     * @return
     */
    public int updateKcinfo(Kcinfo kcinfo) throws Exception {
        return kcinfoMapper.updateKcinfo(kcinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcinfo queryKcinfoById(int id) throws Exception {
        return kcinfoMapper.queryKcinfoById(id);
    }
}
