package com.service;

import java.util.List;

import com.model.Bminfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.BminfoMapper;

/**
 * 部门信息Service实现类
 */
@Service
public class BminfoServiceImpl implements BminfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private BminfoMapper bminfoMapper;

    /**
     * 查询部门信息记录数
     *
     * @param bminfo
     * @return
     */
    public int getCount(Bminfo bminfo) {
        Map<String, Object> map = getQueryMap(bminfo, null);
        return bminfoMapper.getCount(map);
    }

    /**
     * 查询所有部门信息
     *
     * @return
     */
    public List<Bminfo> queryBminfoList(Bminfo bminfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(bminfo, page);
        List<Bminfo> list = bminfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param bminfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Bminfo bminfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bminfo != null) {
            map.put("id", bminfo.getId());
            map.put("name", bminfo.getName());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存部门信息
     *
     * @param bminfo
     * @return
     */
    public int insertBminfo(Bminfo bminfo) throws Exception {
        return bminfoMapper.insertBminfo(bminfo);
    }

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    public int deleteBminfo(int id) throws Exception {
        return bminfoMapper.deleteBminfo(id);
    }

    /**
     * 更新部门信息
     *
     * @param bminfo
     * @return
     */
    public int updateBminfo(Bminfo bminfo) throws Exception {
        return bminfoMapper.updateBminfo(bminfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bminfo queryBminfoById(int id) throws Exception {
        return bminfoMapper.queryBminfoById(id);
    }
}
