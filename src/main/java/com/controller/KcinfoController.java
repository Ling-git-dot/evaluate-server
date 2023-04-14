package com.controller;

import com.model.Kcinfo;
import com.service.KcinfoService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.service.UserinfoService;
import com.model.Userinfo;

/**
 * 课程信息Controller接口类
 */
@RestController
@RequestMapping("/api/kcinfo")
public class KcinfoController {
    /**
     * 注入Service
     */
    @Resource
    private KcinfoService kcinfoService;
    @Resource
    private UserinfoService userinfoService;

    /**
     * 课程信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Kcinfo>> list(@RequestBody Kcinfo kcinfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = kcinfoService.getCount(kcinfo);
        //获取当前页记录
        List<Kcinfo> kcinfoList = kcinfoService.queryKcinfoList(kcinfo, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(kcinfoList, counts, page_count);
    }

    /**
     * 保存课程信息
     *
     * @param kcinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Kcinfo kcinfo, HttpServletRequest request) throws Exception {
        try {
            kcinfoService.insertKcinfo(kcinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改课程信息
     *
     * @param kcinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Kcinfo kcinfo, HttpServletRequest request) throws Exception {
        try {
            kcinfoService.updateKcinfo(kcinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除课程信息
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
            kcinfoService.deleteKcinfo(id);
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
        userinfo.setUtype("1");
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return Response.success(userinfoList);
    }
}
