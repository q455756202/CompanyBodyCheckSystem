package team.yingyingmonster.ccbs.service.serviceimplement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Role;
import team.yingyingmonster.ccbs.database.mapper.RoleMapper;
import team.yingyingmonster.ccbs.database.mapper.dingli.DingRoleMapper;
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


    @Autowired
    public DingRoleMapper dingRoleMapper;
    @Override
    public List<Role> selectAllRole()
    {
        return dingRoleMapper.selectAllRole();
    }

    @Override
    public PageInfo<Role> selectRolePage(Integer pageNum, Integer pageSize) {
        if (pageNum == null)

            pageNum = 1;

        if (pageSize == null)

            pageSize = 5;



        Page<Role> page = PageHelper.startPage(pageNum, pageSize);

        List<Role> list = dingRoleMapper.selectAllRole();



        return new PageInfo<>(page);
    }

}
