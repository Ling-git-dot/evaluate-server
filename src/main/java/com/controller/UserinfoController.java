package com.controller;

import com.model.Kcinfo;
import com.model.Userinfo;
import com.service.KcinfoService;
import com.service.UserinfoService;
import com.util.PageBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.response.Response;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.service.BjinfoService;
import com.model.Bjinfo;

/**
 * 用户信息Controller接口类
 */
@RestController
@RequestMapping("/api/userinfo")
public class UserinfoController {
    /**
     * 注入Service
     */
    @Resource
    private UserinfoService userinfoService;
    @Resource
    private BjinfoService bjinfoService;

    @Resource
    private KcinfoService kcinfoService;

    /**
     * 用户信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Userinfo>> list(@RequestBody Userinfo userinfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = userinfoService.getCount(userinfo);
        //获取当前页记录
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(userinfoList, counts, page_count);
    }

    /**
     * 保存用户信息
     *
     * @param userinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Userinfo userinfo, HttpServletRequest request) throws Exception {
        try {
            userinfoService.insertUserinfo(userinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改用户信息
     *
     * @param userinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Userinfo userinfo, HttpServletRequest request) throws Exception {
        try {
            userinfoService.updateUserinfo(userinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除用户信息
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
            userinfoService.deleteUserinfo(id);
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
    @PostMapping("/listBjinfoAll")
    @CrossOrigin
    public Response<List<Bjinfo>> listBjinfoAll(HttpServletRequest request) throws Exception {
        Bjinfo bjinfo = new Bjinfo();
        List<Bjinfo> bjinfoList = bjinfoService.queryBjinfoList(bjinfo, null);
        request.setAttribute("bjinfoList", bjinfoList);
        return Response.success(bjinfoList);
    }


    /*
     * 获取所有信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/get")
    @CrossOrigin
    public Response<Userinfo> get(@RequestParam Integer id, HttpServletRequest request) throws Exception {
        Userinfo userinfo = userinfoService.queryUserinfoById(id);
        return Response.success(userinfo);
    }

    /**
     * 判断学号/工号是否存在
     *
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/snoExist")
    @CrossOrigin
    public Response snoExist(@RequestParam String sno, @RequestParam String utype, HttpServletRequest request) throws Exception {
        try {
            Userinfo userinfo = new Userinfo();
            userinfo.setSno(sno);
            userinfo.setUtype(utype);
            List list = userinfoService.queryUserinfoList(userinfo, null);
            if (list != null && list.size() > 0) {
                if ("1".equals(utype)) {
                    return Response.error(201, "工号已存在");
                }
                if ("2".equals(utype)) {
                    return Response.error(201, "学号已存在");
                }
            }
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }


}
