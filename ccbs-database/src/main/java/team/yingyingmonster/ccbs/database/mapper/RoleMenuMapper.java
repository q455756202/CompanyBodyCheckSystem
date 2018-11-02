package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.RoleMenuTableKey;

public interface RoleMenuMapper {
    RoleMenuTableKey deleteByPrimaryKey(RoleMenuTableKey key);
    int insert(RoleMenuTableKey key);
    int insertSelective(RoleMenuTableKey key);
}
