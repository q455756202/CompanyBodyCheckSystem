package team.yingyingmonster.ccbs.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 14:31 2018/10/29
 * -
 **/
@Controller
@RequestMapping("/test")
public class TestAction {
    @RequestMapping("/test")
    @ResponseBody
    public Object testHandler(@RequestAttribute("params") Object[] params) {
        return null;
    }

    @RequestMapping("/roleList")
     public String index(){
        return "background-management/role-management";
    }

}
