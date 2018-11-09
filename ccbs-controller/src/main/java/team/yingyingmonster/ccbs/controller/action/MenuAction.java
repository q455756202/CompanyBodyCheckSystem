package team.yingyingmonster.ccbs.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.yingyingmonster.ccbs.database.mapper.MenuMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.MenuService;


import javax.annotation.Resource;

/**
 * @author DingLi <br/>
 * - project: CompanyCheckSystem
 * - create: 17:37 2018/11/1
 * - 菜单管理
 **/
@Controller
@RequestMapping("/menuList")
public class MenuAction {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index() {
        return "background-management/menu-managerment";
    }
    @RequestMapping("/role-menu")
    public String index2() {
        return "background-management/role-management-permissions";
    }
}
