package team.yingyingmonster.ccbs.database.dingli;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Role;

import java.util.List;
@Repository
@Service
public interface RoleListMapper {
    List<Role> selectAllRole();
}
