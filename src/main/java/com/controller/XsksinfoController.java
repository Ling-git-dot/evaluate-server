package com.controller;

import com.model.*;
import com.service.XsksinfoService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.service.UserinfoService;


/**
 * 用户问卷信息Controller接口类
 */
@RestController
@RequestMapping("/api/xsksinfo")
public class XsksinfoController {
    /**
     * 注入Service
     */
    @Resource
    private XsksinfoService xsksinfoService;
    @Resource
    private UserinfoService userinfoService;

    /**
     * 用户问卷信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Xsksinfo>> list(@RequestBody Xsksinfo xsksinfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = xsksinfoService.getCount(xsksinfo);
        //获取当前页记录
        List<Xsksinfo> xsksinfoList = xsksinfoService.queryXsksinfoList(xsksinfo, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(xsksinfoList, counts, page_count);
    }

    /**
     * 保存用户问卷信息
     *
     * @param xsksinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Xsksinfo xsksinfo, HttpServletRequest request) throws Exception {
        try {
            xsksinfoService.insertXsksinfo(xsksinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改用户问卷信息
     *
     * @param xsksinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Xsksinfo xsksinfo, HttpServletRequest request) throws Exception {
        try {
            xsksinfoService.updateXsksinfo(xsksinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除用户问卷信息
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
            xsksinfoService.deleteXsksinfo(id);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /*
     * 获取所有信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/listUserinfoAll")
    @CrossOrigin
    public Response<List<Userinfo>> listUserinfoAll(HttpServletRequest request) throws Exception {
        Userinfo userinfo = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return Response.success(userinfoList);
    }








}
