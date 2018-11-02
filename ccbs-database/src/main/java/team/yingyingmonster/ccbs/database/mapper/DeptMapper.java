package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Dept;

import java.util.List;

public interface DeptMapper {
    Dept selectByPrimaryKey(Long deptid);
    int deleteByPrimaryKey(Long deptid);
    int insert(Dept dept);
    int insertSelective(Dept depts);
    int updateByPrimaryKeySelective(Dept depts);
    int updateByPrimaryKey(Dept dept);
}
