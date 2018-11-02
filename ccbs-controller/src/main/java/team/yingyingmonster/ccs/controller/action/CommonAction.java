package team.yingyingmonster.ccs.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.yingyingmonster.ccs.database.bean.Menu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 13:22 2018/10/30
 * -
 **/
@Controller
@RequestMapping("/common")
public class CommonAction {
    private static final String[]
            MENU_URL = {
                "gateway/index",
                "background-management/index"
            },
            MENU_NAME = {
                "门户页面",
                "后台管理"
            };

    @RequestMapping("/dummy-menu")
    @ResponseBody
    public List<Menu> dummyMenu() {
        List<Menu> menus = new LinkedList<>();

        for (Integer i = 0; i < MENU_URL.length; i++) {
            Menu menu = new Menu();
            menu.setMenuId(i.longValue());
            menu.setMenuUrl(MENU_URL[i]);
            menu.setMenuName(MENU_NAME[i]);
            menu.setMenuState(0);

            menus.add(menu);
        }

        return menus;
    }
}
