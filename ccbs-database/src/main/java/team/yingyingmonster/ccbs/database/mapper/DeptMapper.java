package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Dept;

import java.util.List;

@Repository
public interface DeptMapper {
    Dept selectByPrimaryKey(Long deptid);
    int deleteByPrimaryKey(Long deptid);
    int insert(Dept dept);
    int insertSelective(Dept depts);
    int updateByPrimaryKeySelective(Dept depts);
    int updateByPrimaryKey(Dept dept);
}
