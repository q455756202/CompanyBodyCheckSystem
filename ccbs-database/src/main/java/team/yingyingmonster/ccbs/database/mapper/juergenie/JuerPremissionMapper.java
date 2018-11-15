package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Role;

@Repository
public interface JuerPremissionMapper {
    Role selectRoleByMenuname(String menuname);
}
