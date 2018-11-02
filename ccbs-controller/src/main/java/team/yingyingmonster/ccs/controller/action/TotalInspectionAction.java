package team.yingyingmonster.ccs.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyCheckSystem
 * - create: 17:37 2018/10/31
 * - 总检
 **/

@Controller

@RequestMapping("/total-inspection")

public class TotalInspectionAction {

    @RequestMapping("/index")
    public String index(){
        return "totalinspection/total-inspection";
    }

    /**
     * 查询待总检人员
     * @return
     */
    @RequestMapping("/findUsers")
    public String findUsers(){
        //List<User> userList=new ArrayList<User>();

        return "totalinspection/total-inspection";
    }

    /**
     * 保存总检内容
     * @return
     */
    @RequestMapping("/write")
    public String writeTotalInspection(){

        return "";
    }


}
