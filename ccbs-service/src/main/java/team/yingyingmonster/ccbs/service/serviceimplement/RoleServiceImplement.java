package team.yingyingmonster.ccbs.service.serviceimplement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Role;
import team.yingyingmonster.ccbs.database.dingli.RoleListMapper;
import team.yingyingmonster.ccbs.database.mapper.RoleMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.RoleService;

import java.util.List;

/**
 * @author DingLi <br/>
 * - project: CompanyCheckSystem
 * - create: 10:15 2018/11/1
 * - 角色管理实现
 **/
@Service
public class RoleServiceImplement implements RoleService {

    private List roleList;
    private String flag;
    @Autowired
    public RoleMapper roleMapper;
    public RoleListMapper roleListMapper;
    @Override
    public List<Role> selectAllRole()
    {
        return roleListMapper.selectAllRole();
    }

    @Override
    public PageInfo<Role> selectRolePage(Integer pageNum, Integer pageSize) {
        if (pageNum == null)

            pageNum = 1;

        if (pageSize == null)

            pageSize = 5;



        Page<Role> page = PageHelper.startPage(pageNum, pageSize);

        List<Role> list = roleListMapper.selectAllRole();



        return new PageInfo<>(page);
    }
}
