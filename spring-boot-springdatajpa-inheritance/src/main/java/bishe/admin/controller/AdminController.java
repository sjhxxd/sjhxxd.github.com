package bishe.admin.controller;

import bishe.admin.service.AdminService;
import bishe.frontentity.ReturnModel;
import bishe.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjh on 16/5/23.
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    @Qualifier("AdminImpl")
    private AdminService service;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ReturnModel AdminLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        try {
            if (service.getUserPassWord(userName).equals(MD5Util.MD5Encode(password, "UTF-8"))) {
                Map map = new HashMap();
                map.put("userId", service.getUserId(userName));
                map.put("userName", userName);
                return new ReturnModel(1, map);
            } else {
                return new ReturnModel(0, "用户名或密码错误");
            }
        } catch (Exception e) {
            return new ReturnModel(0, "用户名或密码错误");
        }
    }

    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public ReturnModel UpdateUserPwd(
            @RequestParam("userId") int userId,
            @RequestParam("userName") String userName,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        if (!service.checkPassWord(userId).equals(MD5Util.MD5Encode(oldPassword, "UTF-8"))) {
            return new ReturnModel(0, "原密码不正确");
        } else {
            service.updateByUserId(userId, userName, newPassword);
            System.out.println("新密码是:" + newPassword);
            return new ReturnModel(1, "管理员密码修改成功");
        }
    }
}
