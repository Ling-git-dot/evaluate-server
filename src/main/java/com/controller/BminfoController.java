package com.controller;

import com.model.Bminfo;
import com.service.BminfoService;
import com.util.PageBean;

import java.util.List;

import com.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 部门信息Controller接口类
 */
@RestController
@RequestMapping("/api/bminfo")
public class BminfoController {
    /**
     * 注入Service
     */
    @Resource
    private BminfoService bminfoService;

    /**
     * 部门信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @CrossOrigin
    public Response<List<Bminfo>> list(@RequestBody Bminfo bminfo, @RequestParam Integer currentPage, HttpServletRequest request) throws Exception {
        int offset = (currentPage - 1) * PageBean.PAGE_IETM;
        int counts = 0;  //总记录数
        PageBean page = new PageBean(offset);
        //查询记录总数
        counts = bminfoService.getCount(bminfo);
        //获取当前页记录
        List<Bminfo> bminfoList = bminfoService.queryBminfoList(bminfo, page);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        return Response.success(bminfoList, counts, page_count);
    }

    /**
     * 保存部门信息
     *
     * @param bminfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/add")
    @CrossOrigin
    public Response add(@RequestBody Bminfo bminfo, HttpServletRequest request) throws Exception {
        try {
            bminfoService.insertBminfo(bminfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 修改部门信息
     *
     * @param bminfo
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/update")
    @CrossOrigin
    public Response update(@RequestBody Bminfo bminfo, HttpServletRequest request) throws Exception {
        try {
            bminfoService.updateBminfo(bminfo);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }

    /**
     * 删除部门信息
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
            bminfoService.deleteBminfo(id);
        } catch (Exception e) {
            return Response.error();
        }
        return Response.success();
    }
}
