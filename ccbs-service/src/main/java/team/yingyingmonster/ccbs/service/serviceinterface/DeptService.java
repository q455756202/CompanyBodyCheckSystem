package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Dept;

public interface DeptService {
    Dept selectByPrimaryKey(Long deptid);
    int deleteByPrimaryKey(Long deptid);
    int insert(Dept dept);
    int insertSelective(Dept depts);
    int updateByPrimaryKeySelective(Dept depts);
    int updateByPrimaryKey(Dept dept);
}
