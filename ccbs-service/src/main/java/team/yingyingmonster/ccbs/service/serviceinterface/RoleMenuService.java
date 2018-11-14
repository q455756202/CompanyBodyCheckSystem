package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.RoleMenuTableKey;

public interface RoleMenuService {
    RoleMenuTableKey deleteByPrimaryKey(RoleMenuTableKey key);
    int insert(RoleMenuTableKey key);
    int insertSelective(RoleMenuTableKey key);
}
