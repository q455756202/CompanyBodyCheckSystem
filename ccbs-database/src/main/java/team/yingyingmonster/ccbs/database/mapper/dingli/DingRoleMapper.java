package team.yingyingmonster.ccbs.database.mapper.dingli;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Role;

import java.util.List;
@Repository
public interface DingRoleMapper {
    List<Role> selectAllRole();
}
