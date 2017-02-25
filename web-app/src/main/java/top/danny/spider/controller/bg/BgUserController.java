package top.danny.spider.controller.bg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-25 00:16:59
 */
@RequestMapping("/bg/user")
@Controller
public class BgUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/manager")
    public ModelAndView manager(Map map){
        ModelAndView modelAndView=new ModelAndView("bg/user/manager");
        List<User> userList= userService.findAllUser();
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
