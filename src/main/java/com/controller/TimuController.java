package com.controller;

import com.model.Timu;
import com.model.Xsksitem;
import com.service.TimuService;
import com.service.XsksitemService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



/**
 * 题目信息Controller接口类
 */
@RestController
@RequestMapping("/api/timu")
public class TimuController {
    /**
     * 注入Service
     */
    @Resource
    private TimuService timuService;

    @Resource
    private XsksitemService xsksitemService;
    /**
     * 题目信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Timu>> list(@RequestBody Timu timu, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = timuService.getCount(timu);
        //获取当前页记录
        List<Timu> timuList = timuService.queryTimuList(timu, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(timuList, counts, page_count);
    }


    /**
     * 题目信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list1")
    @CrossOrigin
    public Response<List<Timu>> list1(@RequestBody Timu timu , HttpServletRequest request) throws Exception {
        List<Timu> timuList = timuService.queryTimuList(timu,null);
        if(timuList!=null && timuList.size()>0){

            for (Timu timu1 : timuList) {
                Xsksitem xsksitem = new Xsksitem();
                xsksitem.setTmid(timu1.getId());
                xsksitem.setKsid(timu.getDtid());
                xsksitem.setDa("A");
                timu1.setAnums(xsksitemService.getCount(xsksitem));
                xsksitem.setDa("B");
                timu1.setBnums(xsksitemService.getCount(xsksitem));
                xsksitem.setDa("C");
                timu1.setCnums(xsksitemService.getCount(xsksitem));
                xsksitem.setDa("D");
                timu1.setDnums(xsksitemService.getCount(xsksitem));
            }
        }
        return Response.success(timuList);
    }



    /**
     * 保存题目信息
     *
     * @param timu
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Timu timu, HttpServletRequest request) throws Exception {
        try {
            timuService.insertTimu(timu);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改题目信息
     *
     * @param timu
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Timu timu, HttpServletRequest request) throws Exception {
        try {
            timuService.updateTimu(timu);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除题目信息
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
            timuService.deleteTimu(id);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }


    /*
     * 获取题目信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/listTimuAll")
    @CrossOrigin
    public Response<List<Timu>> listTimuAll(@RequestParam Integer ksid, HttpServletRequest request) throws Exception {
        Timu timu = new Timu();
        timu.setDtid(ksid);
        List<Timu> timus = timuService.queryTimuList(timu,null);
        return Response.success(timus);
    }
}
