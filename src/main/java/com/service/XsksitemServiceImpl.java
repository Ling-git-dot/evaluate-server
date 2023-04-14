package com.service;

import java.util.List;

import com.model.Xsksitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.XsksitemMapper;

/**
 * 问卷明细Service实现类
 */
@Service
public class XsksitemServiceImpl implements XsksitemService {
    /**
     * 注入mapper
     */
    @Autowired
    private XsksitemMapper xsksitemMapper;

    /**
     * 查询问卷明细记录数
     *
     * @param xsksitem
     * @return
     */
    public int getCount(Xsksitem xsksitem) {
        Map<String, Object> map = getQueryMap(xsksitem, null);
        return xsksitemMapper.getCount(map);
    }

    /**
     * 查询所有问卷明细
     *
     * @return
     */
    public List<Xsksitem> queryXsksitemList(Xsksitem xsksitem, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(xsksitem, page);
        List<Xsksitem> list = xsksitemMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param xsksitem
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Xsksitem xsksitem, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (xsksitem != null) {
            map.put("id", xsksitem.getId());
            map.put("xsksid", xsksitem.getXsksid());
            map.put("tmid", xsksitem.getTmid());
            map.put("da", xsksitem.getDa());
            map.put("ctype", xsksitem.getCtype());
            map.put("ksid", xsksitem.getKsid());

        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int insertXsksitem(Xsksitem xsksitem) throws Exception {
        return xsksitemMapper.insertXsksitem(xsksitem);
    }

    /**
     * 删除问卷明细
     *
     * @param id
     * @return
     */
    public int deleteXsksitem(int id) throws Exception {
        return xsksitemMapper.deleteXsksitem(id);
    }

    /**
     * 更新问卷明细
     *
     * @param xsksitem
     * @return
     */
    public int updateXsksitem(Xsksitem xsksitem) throws Exception {
        return xsksitemMapper.updateXsksitem(xsksitem);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Xsksitem queryXsksitemById(int id) throws Exception {
        return xsksitemMapper.queryXsksitemById(id);
    }
}
