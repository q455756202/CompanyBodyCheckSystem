package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Menu;
import team.yingyingmonster.ccbs.service.serviceinterface.MenuService;

import java.util.List;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:29 2018/11/2
 * - 菜单管理
 **/
@Service
public class MenuServiceImplement implements MenuService {
    @Override
    public boolean hasPremission(Account accountBean, Menu menuBean)
    {
        return false;
    }

    @Override
    public List<Menu> selectAccountMenuByRoleId(Long roleId)
    {
        return null;
    }
}
