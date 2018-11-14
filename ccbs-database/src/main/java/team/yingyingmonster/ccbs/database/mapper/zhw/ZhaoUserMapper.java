package team.yingyingmonster.ccbs.database.mapper.zhw;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

@Repository
public interface ZhaoUserMapper {
    Long getNewUserId();//获取体检人ID
    Integer insertUsers(List<User> userList);//插入体检人员信息
    List<User> selectBeforeUsers(Long companyId);//查询已插入的体检人员
    Integer insertUser(User user);
    Integer deleteUser(Long userId);//删除用户
    Integer updateUser(User user);//修改用户
}
