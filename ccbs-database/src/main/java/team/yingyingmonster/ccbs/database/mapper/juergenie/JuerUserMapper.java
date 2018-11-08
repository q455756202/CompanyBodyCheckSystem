package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerUser;

import java.util.List;

@Repository
public interface JuerUserMapper {
    List<User> selectAllUsers();
    List<User> selectUsersByCondition(User condition);
    List<User> selectUsersByCompanyid(Long companyid);
    List<JuerUser> selectJuerUsersByCompanyid(Long companyid);
}
