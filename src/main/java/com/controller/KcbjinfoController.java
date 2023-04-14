package com.controller;

import com.model.Kcbjinfo;
import com.service.KcbjinfoService;
import com.service.UserinfoService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.service.KcinfoService;
import com.model.Kcinfo;
import com.service.BjinfoService;
import com.model.Bjinfo;

/**
 * 课程班级信息Controller接口类
 */
@RestController
@RequestMapping("/api/kcbjinfo")
public class KcbjinfoController {
    /**
     * 注入Service
     */
    @Resource
    private KcbjinfoService kcbjinfoService;
    @Resource
    private KcinfoService kcinfoService;
    @Resource
    private BjinfoService bjinfoService;
    @Resource
    private UserinfoService userinfoService;
    /**
     * 课程班级信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Kcbjinfo>> list(@RequestBody Kcbjinfo kcbjinfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = kcbjinfoService.getCount(kcbjinfo);
        //获取当前页记录
        List<Kcbjinfo> kcbjinfoList = kcbjinfoService.queryKcbjinfoList(kcbjinfo, page);
        if(kcbjinfoList!=null && kcbjinfoList.size()>0){
            for (Kcbjinfo kcbjinfo1 : kcbjinfoList) {
                kcbjinfo1.getKcinfoVO().setUserinfoVO(userinfoService.queryUserinfoById(kcbjinfo1.getKcinfoVO().getTid()));
            }
        }

        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(kcbjinfoList, counts, page_count);
    }

    /**
     * 保存课程班级信息
     *
     * @param kcbjinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Kcbjinfo kcbjinfo, HttpServletRequest request) throws Exception {
        try {
            int count = kcbjinfoService.getCount(kcbjinfo);
            if(count>0){
                return Response.error(201,"无需重复绑定");
            }
            kcbjinfoService.insertKcbjinfo(kcbjinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改课程班级信息
     *
     * @param kcbjinfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Kcbjinfo kcbjinfo, HttpServletRequest request) throws Exception {
        try {
            kcbjinfoService.updateKcbjinfo(kcbjinfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除课程班级信息
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
            kcbjinfoService.deleteKcbjinfo(id);
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
    @PostMapping("/listKcinfoAll")
    @CrossOrigin
    public Response<List<Kcinfo>> listKcinfoAll(HttpServletRequest request) throws Exception {
        Kcinfo kcinfo = new Kcinfo();
        List<Kcinfo> kcinfoList = kcinfoService.queryKcinfoList(kcinfo, null);
        request.setAttribute("kcinfoList", kcinfoList);
        return Response.success(kcinfoList);
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
}
