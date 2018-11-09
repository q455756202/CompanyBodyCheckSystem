package team.yingyingmonster.ccbs.database.mapper.zhw;

import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

public interface ZhaoUserMapper {
    Long getNewUserId();//获取体检人ID
    List<User> selectBeforeUsers(Long companyId);
}
