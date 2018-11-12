package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.RoleMenuTableKey;
import team.yingyingmonster.ccbs.service.serviceinterface.RoleMenuService;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:41 2018/11/2
 * - 为角色分配菜单
 **/
@Service
public class RoleMenuServiceImplement implements RoleMenuService {

    @Override
    public RoleMenuTableKey deleteByPrimaryKey(RoleMenuTableKey key) {
        return null;
    }

    @Override
    public int insert(RoleMenuTableKey key) {
        return 0;
    }

    @Override
    public int insertSelective(RoleMenuTableKey key) {
        return 0;
    }
}
