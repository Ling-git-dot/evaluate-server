package com.service;

import java.util.List;

import com.model.Xsksinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.XsksinfoMapper;

/**
 * 用户问卷信息Service实现类
 */
@Service
public class XsksinfoServiceImpl implements XsksinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private XsksinfoMapper xsksinfoMapper;

    /**
     * 查询用户问卷信息记录数
     *
     * @param xsksinfo
     * @return
     */
    public int getCount(Xsksinfo xsksinfo) {
        Map<String, Object> map = getQueryMap(xsksinfo, null);
        return xsksinfoMapper.getCount(map);
    }

    /**
     * 查询所有用户问卷信息
     *
     * @return
     */
    public List<Xsksinfo> queryXsksinfoList(Xsksinfo xsksinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(xsksinfo, page);
        List<Xsksinfo> list = xsksinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param xsksinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Xsksinfo xsksinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xsksinfo != null) {
            map.put("id", xsksinfo.getId());
            map.put("sid", xsksinfo.getSid());
            map.put("ksid", xsksinfo.getKsid());
            map.put("tid", xsksinfo.getTid());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int insertXsksinfo(Xsksinfo xsksinfo) throws Exception {
        return xsksinfoMapper.insertXsksinfo(xsksinfo);
    }

    /**
     * 删除用户问卷信息
     *
     * @param id
     * @return
     */
    public int deleteXsksinfo(int id) throws Exception {
        return xsksinfoMapper.deleteXsksinfo(id);
    }

    /**
     * 更新用户问卷信息
     *
     * @param xsksinfo
     * @return
     */
    public int updateXsksinfo(Xsksinfo xsksinfo) throws Exception {
        return xsksinfoMapper.updateXsksinfo(xsksinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksinfo queryXsksinfoById(int id) throws Exception {
        return xsksinfoMapper.queryXsksinfoById(id);
    }
}
