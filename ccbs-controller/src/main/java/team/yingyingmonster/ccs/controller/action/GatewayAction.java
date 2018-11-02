package team.yingyingmonster.ccs.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 10:23 2018/10/30
 * -
 **/
@Controller
@RequestMapping("/gateway")
public class GatewayAction {
    @RequestMapping("/index")
    public String index() {
        return "gateway/index";
    }
}
