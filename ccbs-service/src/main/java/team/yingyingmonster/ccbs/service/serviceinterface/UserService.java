package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

public interface UserService {
    Integer insertUsers(Long companyId, List<String[]> userList);//插入体检人员信息
    List<User> selectUsers(Long companyId);//查询已插入体检人员名单
    Integer insertUser(Long companyId, User user);
    boolean deleteUser(Long userId);//删除用户
    boolean updateUser(User user);//修改用户
}
