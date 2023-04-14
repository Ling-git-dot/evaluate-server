package com.controller;

import com.model.*;
import com.service.XsksitemService;
import com.util.PageBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.service.XsksinfoService;
import com.service.TimuService;

/**
 * 问卷明细Controller接口类
 */
@RestController
@RequestMapping("/api/xsksitem")
public class XsksitemController {
    /**
     * 注入Service
     */
    @Resource
    private XsksitemService xsksitemService;
    @Resource
    private XsksinfoService xsksinfoService;
    @Resource
    private TimuService timuService;

    /**
     * 问卷明细列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Xsksitem>> list(@RequestBody Xsksitem xsksitem, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = xsksitemService.getCount(xsksitem);
        //获取当前页记录
        List<Xsksitem> xsksitemList = xsksitemService.queryXsksitemList(xsksitem, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(xsksitemList, counts, page_count);
    }

    /**
     * 保存问卷明细
     *
     * @param xsksitem
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Xsksitem da,@RequestParam Integer ksid,@RequestParam Integer uid, HttpServletRequest request) throws Exception {
        try {
            Timu timu = new Timu();
            timu.setDtid(ksid);
            List<Timu> timus = timuService.queryTimuList(timu,null);
            Xsksinfo xsksinfo = new Xsksinfo();
            xsksinfo.setSid(uid);
            xsksinfo.setKsid(ksid);
            xsksinfo.setCdate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            String[] das = da.getDa().split(",");
            LinkedList<Xsksitem> xsksitems = new LinkedList<Xsksitem>();
            for(int i = 0 ;i<timus.size();i++){
                Timu tm = timus.get(i);
                Xsksitem xsksitem = new Xsksitem();
                xsksitem.setTmid(tm.getId());
                xsksitem.setDa(das[i]);
                xsksitems.add(xsksitem);
            }
            xsksinfoService.insertXsksinfo(xsksinfo);

            for (Xsksitem xsksitem : xsksitems) {
                xsksitem.setXsksid(xsksinfo.getId());
                xsksitemService.insertXsksitem(xsksitem);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改问卷明细
     *
     * @param xsksitem
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Xsksitem xsksitem, HttpServletRequest request) throws Exception {
        try {
            xsksitemService.updateXsksitem(xsksitem);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除问卷明细
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
            xsksitemService.deleteXsksitem(id);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }


    /**
     * 检测能否问卷
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/checkks")
    @CrossOrigin
    public Response checkks(@RequestParam Integer uid,@RequestParam Integer ksid,  HttpServletRequest request) throws Exception {
        try {

            Xsksinfo xsksinfo = new Xsksinfo();
            xsksinfo.setSid(uid);
            xsksinfo.setKsid(ksid);
            int count = xsksinfoService.getCount(xsksinfo);
            if(count>0){
                return  Response.error(201,"你已填写问卷，不用重复提交");
            }


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
    @PostMapping("/listXsksinfoAll")
    @CrossOrigin
    public Response<List<Xsksinfo>> listXsksinfoAll(HttpServletRequest request) throws Exception {
        Xsksinfo xsksinfo = new Xsksinfo();
        List<Xsksinfo> xsksinfoList = xsksinfoService.queryXsksinfoList(xsksinfo, null);
        request.setAttribute("xsksinfoList", xsksinfoList);
        return Response.success(xsksinfoList);
    }

    /*
     * 获取所有信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/listTimuAll")
    @CrossOrigin
    public Response<List<Timu>> listTimuAll(HttpServletRequest request) throws Exception {
        Timu timu = new Timu();
        List<Timu> timuList = timuService.queryTimuList(timu, null);
        request.setAttribute("timuList", timuList);
        return Response.success(timuList);
    }


    /*
     * 获取题目信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/listXsksitem")
    @CrossOrigin
    public Response<List<Xsksitem>> listXsksitem(@RequestParam Integer id, HttpServletRequest request) throws Exception {
        Xsksitem xsksitem = new Xsksitem();
        xsksitem.setXsksid(id);
        xsksitem.setCtype(2);
        List<Xsksitem> xsksitems = xsksitemService.queryXsksitemList(xsksitem,null);
        return Response.success(xsksitems);
    }



    /*
     * 统计
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/report")
    @CrossOrigin
    public Response<Report> report1(@RequestParam Integer tmid,@RequestParam Integer dtid, HttpServletRequest request) throws Exception {
        List<String> names = new ArrayList<String>();
        List<Integer> nums = new ArrayList<Integer>();
        Report reports = new Report();
        Timu timu = timuService.queryTimuById(tmid);
        if(timu.getCtype()==1){
            Xsksitem xsksitem = new Xsksitem();
            xsksitem.setTmid(timu.getId());
            xsksitem.setKsid(dtid);
            xsksitem.setDa("A");
            timu.setAnums(xsksitemService.getCount(xsksitem));
            xsksitem.setDa("B");
            timu.setBnums(xsksitemService.getCount(xsksitem));
            xsksitem.setDa("C");
            timu.setCnums(xsksitemService.getCount(xsksitem));
            xsksitem.setDa("D");
            timu.setDnums(xsksitemService.getCount(xsksitem));

            names.add(timu.getXxa());
            nums.add(timu.getAnums());
            names.add(timu.getXxb());
            nums.add(timu.getBnums());
            names.add(timu.getXxc());
            nums.add(timu.getCnums());
            names.add(timu.getXxd());
            nums.add(timu.getDnums());
            reports.setNames(names);
            reports.setNums(nums);
        }else{
            Xsksitem xsksitem = new Xsksitem();
            xsksitem.setTmid(timu.getId());
            xsksitem.setKsid(dtid);
            List<Xsksitem> xsksitems = xsksitemService.queryXsksitemList(xsksitem,null);
            reports.setDatas(xsksitems);
        }



        return Response.success(reports);
    }

}
