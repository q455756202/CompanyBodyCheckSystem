package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Role;

@Repository
public interface RoleMapper {
    Role selectByPrimaryKey(Long roleid);
    int deleteByPrimaryKey(Long roleid);
    int insert(Role role);
    int insertSelective(Role role);
    int updateByPrimaryKeySelective(Role role);
    int updateByPrimaryKey(Role role);
}
