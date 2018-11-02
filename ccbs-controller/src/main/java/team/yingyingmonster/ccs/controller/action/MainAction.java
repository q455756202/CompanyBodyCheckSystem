package team.yingyingmonster.ccs.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 15:41 2018/10/30
 * -
 **/
@Controller
@RequestMapping("/main")
public class MainAction {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
