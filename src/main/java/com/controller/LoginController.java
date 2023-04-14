package com.controller;

import com.model.Admin;
import com.model.Userinfo;
import com.response.Response;
import com.service.AdminService;
import com.service.UserinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/ulogin")
public class LoginController {
    @Resource
    private AdminService adminService;
    @Resource
    private UserinfoService userinfoService;

    /**
     * 管理员登录
     *
     * @param admin
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/login")
    @CrossOrigin
    public Response login(@RequestBody Admin admin, HttpServletRequest request) throws Exception {
        try {
            if ("学生".equals(admin.getUtype())) {
                Userinfo userinfo = new Userinfo();
                userinfo.setSno(admin.getUsername());
                userinfo.setUpwd(admin.getUserpw());
                userinfo.setUtype("2");
                List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
                if (userinfoList != null && userinfoList.size() > 0) {
                    userinfo = userinfoList.get(0);
                    return Response.success(userinfo);
                }
            }
            if ("老师".equals(admin.getUtype())) {
                Userinfo userinfo = new Userinfo();
                userinfo.setSno(admin.getUsername());
                userinfo.setUpwd(admin.getUserpw());
                userinfo.setUtype("1");
                List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
                if (userinfoList != null && userinfoList.size() > 0) {
                    userinfo = userinfoList.get(0);
                    return Response.success(userinfo);
                }
            }
            if ("管理员".equals(admin.getUtype())) {
                List<Admin> adminList = adminService.queryAdminList(admin, null);
                if (adminList != null && adminList.size() > 0) {
                    Admin ainfo = adminList.get(0);
                    return Response.success(ainfo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Response.error();
        }
        return Response.error(201, "用户名密码错误");
    }


}
