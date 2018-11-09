package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.User;

@Repository
public interface UserMapperWeng {
    User selectUserByUserId(Long userId);
}
