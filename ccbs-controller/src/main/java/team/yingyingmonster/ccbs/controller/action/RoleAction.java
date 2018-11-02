package team.yingyingmonster.ccbs.controller.action;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccbs.controller.bean.ResultMessage;
import team.yingyingmonster.ccbs.database.bean.Role;
import team.yingyingmonster.ccbs.service.serviceinterface.RoleService;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author DingLi <br/>
 * - project: CompanyCheckSystem
 * - create: 10:38 2018/11/1
 * - 角色管理
 **/
@Controller
@RequestMapping("/role")
public class RoleAction {
    private List roleList;
    private String flag;
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/roleList")
    @ResponseBody
    public ResultMessage roleList(Role roleBean, Long startTime, Long endTime){

        PageInfo<Role> pageInfo= roleService.selectRolePage(1,5);

         return ResultMessage.createSuccessMessage("获取成功！", pageInfo);
    }
    @RequestMapping(value = "/roleList2")
    public String index(){
        return "background-management/index";
    }
 }
