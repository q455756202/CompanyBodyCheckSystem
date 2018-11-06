package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.UserCheck;

@Repository
public interface UserCheckMapper {
    UserCheck selectByPrimaryKey(Long usercheckid);
    int deleteByPrimaryKey(Long usercheckid);
    int insert(UserCheck userCheck);
    int insertSelective(UserCheck userCheck);
    int updateByPrimaryKeySelective(UserCheck userCheck);
    int updateByPrimaryKey(UserCheck userCheck);
}
