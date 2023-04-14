package com.service;

import java.util.List;

import com.model.Kcbjinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.KcbjinfoMapper;

/**
 * 课程班级信息Service实现类
 */
@Service
public class KcbjinfoServiceImpl implements KcbjinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private KcbjinfoMapper kcbjinfoMapper;

    /**
     * 查询课程班级信息记录数
     *
     * @param kcbjinfo
     * @return
     */
    public int getCount(Kcbjinfo kcbjinfo) {
        Map<String, Object> map = getQueryMap(kcbjinfo, null);
        return kcbjinfoMapper.getCount(map);
    }

    /**
     * 查询所有课程班级信息
     *
     * @return
     */
    public List<Kcbjinfo> queryKcbjinfoList(Kcbjinfo kcbjinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(kcbjinfo, page);
        List<Kcbjinfo> list = kcbjinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param kcbjinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Kcbjinfo kcbjinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (kcbjinfo != null) {
            map.put("id", kcbjinfo.getId());
            map.put("kcid", kcbjinfo.getKcid());
            map.put("bjid", kcbjinfo.getBjid());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int insertKcbjinfo(Kcbjinfo kcbjinfo) throws Exception {
        return kcbjinfoMapper.insertKcbjinfo(kcbjinfo);
    }

    /**
     * 删除课程班级信息
     *
     * @param id
     * @return
     */
    public int deleteKcbjinfo(int id) throws Exception {
        return kcbjinfoMapper.deleteKcbjinfo(id);
    }

    /**
     * 更新课程班级信息
     *
     * @param kcbjinfo
     * @return
     */
    public int updateKcbjinfo(Kcbjinfo kcbjinfo) throws Exception {
        return kcbjinfoMapper.updateKcbjinfo(kcbjinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Kcbjinfo queryKcbjinfoById(int id) throws Exception {
        return kcbjinfoMapper.queryKcbjinfoById(id);
    }
}
