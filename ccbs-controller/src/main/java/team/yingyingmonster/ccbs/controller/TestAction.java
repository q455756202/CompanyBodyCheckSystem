package team.yingyingmonster.ccbs.controller;

import com.google.gson.JsonElement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.User;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:51 2018/11/2
 * -
 **/
@Controller
@RequestMapping("/test")
public class TestAction {
    @RequestMapping("/test")
    @ResponseBody
    public ResultMessage test(@RequestBody JsonElement param) {
        System.out.println(param);
        return ResultMessage.createSuccessMessage("success!", param);
    }
}
