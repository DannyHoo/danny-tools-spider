package top.danny.spider.controller.bg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BgIndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-22 23:20:26
 */
@Controller
@RequestMapping("/bg")
public class BgIndexController {

    @RequestMapping("/index")
    public String index(){
        return "bg/index";
    }

    @RequestMapping("/tables")
    public String tables(){
        return "bg/tables";
    }

    @RequestMapping("/calendar")
    public String calendar(){
        return "bg/calendar";
    }

    @RequestMapping("/form")
    public String form(){
        return "bg/form";
    }

    @RequestMapping("/chart")
    public String chart(){
        return "bg/chart";
    }



    @RequestMapping("/table-list")
    public String table_list(){
        return "bg/table-list";
    }

    @RequestMapping("/table-list-img")
    public String table_list_img(){
        return "bg/table-list-img";
    }

    @RequestMapping("/sign-up")
    public String sign_up(){
        return "bg/sign-up";
    }

    @RequestMapping("/login")
    public String login(){
        return "bg/login";
    }


    @RequestMapping("/404")
    public String error_404(){
        return "bg/404";
    }
}
