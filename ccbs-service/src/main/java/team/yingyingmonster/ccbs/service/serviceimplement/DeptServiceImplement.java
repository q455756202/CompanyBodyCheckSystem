package team.yingyingmonster.ccbs.service.serviceimplement;

import team.yingyingmonster.ccbs.database.bean.Dept;
import team.yingyingmonster.ccbs.service.serviceinterface.DeptService;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:49 2018/11/2
 * - 科室管理
 **/

public class DeptServiceImplement implements DeptService {

    @Override
    public Dept selectByPrimaryKey(Long deptid) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Long deptid) {
        return 0;
    }

    @Override
    public int insert(Dept dept) {
        return 0;
    }

    @Override
    public int insertSelective(Dept depts) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Dept depts) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Dept dept) {
        return 0;
    }
}
