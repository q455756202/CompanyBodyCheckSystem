package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.User;

import java.util.List;

@Repository
public interface UserMapper {
    User selectByPrimaryKey(Long userid);
    int deleteByPrimaryKey(Long userid);
    int insert(User user);
    int insertSelective(List<User> users);
    int updateByPrimaryKeySelective(List<User> users);
    int updateByPrimaryKey(User user);
}
