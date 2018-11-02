package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.RoleMenuTableKey;

@Repository
public interface RoleMenuMapper {
    RoleMenuTableKey deleteByPrimaryKey(RoleMenuTableKey key);
    int insert(RoleMenuTableKey key);
    int insertSelective(RoleMenuTableKey key);
}
