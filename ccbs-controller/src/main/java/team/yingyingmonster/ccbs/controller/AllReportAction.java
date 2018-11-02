package team.yingyingmonster.ccbs.controller;

import oracle.sql.CLOB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clob")
public class AllReportAction {
    @RequestMapping("/string")
    private  String clob(CLOB clob){

        return null;
    }
}
