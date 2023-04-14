package com.controller;

import com.model.Bjinfo;
import com.service.BjinfoService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 班级信息Controller接口类
 */
@RestController
@RequestMapping("/api/bjinfo")
public class BjinfoController {
    /**
     * 注入Service
     */
    @Resource
    private BjinfoService bjinfoService;

    /**
     * 班级信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Bjinfo>> list(@RequestBody Bjinfo bjinfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = bjinfoService.getCount(bjinfo);
        //获取当前页记录
        List<Bjinfo> bjinfoList = bjinfoService.queryBjinfoList(bjinfo, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(bjinfoList, counts, page_count);
    }

    /**
     * 保存班级信息
     *
     * @param bjinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Bjinfo bjinfo, HttpServletRequest request) throws Exception {
        try {
            bjinfoService.insertBjinfo(bjinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改班级信息
     *
     * @param bjinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Bjinfo bjinfo, HttpServletRequest request) throws Exception {
        try {
            bjinfoService.updateBjinfo(bjinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除班级信息
     *
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/del")
    @CrossOrigin
    public Response del(@RequestParam Integer id, HttpServletRequest request) throws Exception {
        try {
            bjinfoService.deleteBjinfo(id);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }
}
