package team.yingyingmonster.ccbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:24 2018/11/2
 * -
 **/
@Controller
@RequestMapping("/company-check")
public class CompanyCheckAction {
    @RequestMapping("/index")
    public String index() {
        return "company-check/index";
    }
}
