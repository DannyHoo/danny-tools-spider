package top.danny.spider.controller.bg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
public class BgUserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/manager")
    public ModelAndView manager(Map map) {
        int pageNumber = getPageNumber(map);
        int pagzSize = getPageSize(map);
        List<User> userList = userService.findUserPage(pageNumber, pagzSize);
        ModelAndView modelAndView = new ModelAndView("bg/user/manager");
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("a", "danny");
        return modelAndView;
    }

    @RequestMapping("/index")
    public ModelAndView index(Map map) {

        ModelAndView modelAndView = new ModelAndView("bg/user/index");
        return modelAndView;
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList() {
        List<User> userList = userService.findUserPage(1, 10);
        return userList;
    }

    @RequestMapping("/getUserPage")
    @ResponseBody
    public Map<String, Object> getUserPage(HttpServletRequest request, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int pageNumber = getPageNumber(request);
        pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = getPageSize(request);
        pageSize=Integer.parseInt(request.getParameter("pageSize"));
        List<User> userList = userService.findUserPage(pageNumber, pageSize);
        resultMap.put("userListData", getListData(userList));
        return resultMap;
    }


    public String getListData(List<User> userList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (User user : userList) {
            stringBuffer.append("<tr class=\"gradeX\"><td>")
                    .append(user.getUserName())
                    .append("</td><td>")
                    .append(user.getRealName())
                    .append("</td><td>")
                    .append(user.getIdCardNo())
                    .append("</td><td>")
                    .append(user.getMobileNo())
                    .append("</td><td>")
                    .append(user.getEmail())
                    .append("</td><td>")
                    .append(user.getBirthday())
                    .append("</td><td><div class=\"tpl-table-black-operation\">")
                    .append("<a href=\"javascript:;\"><i class=\"am-icon-pencil\"></i>编辑</a>")
                    .append("<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\"><i class=\"am-icon-trash\"></i>删除</a>")
                    .append("</div></td></tr>");
        }
        return stringBuffer.toString();
    }
}
