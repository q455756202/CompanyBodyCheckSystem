package team.yingyingmonster.ccbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:17 2018/11/3
 * - 处理主页业务
 **/
@Controller
@RequestMapping("/main")
public class MainAction {

    @RequestMapping("/index")
    public String index(){
        return "main/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "main/center";
    }

}
