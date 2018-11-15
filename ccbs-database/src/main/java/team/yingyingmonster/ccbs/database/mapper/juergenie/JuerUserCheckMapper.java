package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import team.yingyingmonster.ccbs.database.bean.UserCheck;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerUserCheck;

import java.util.List;

public interface JuerUserCheckMapper {
    Long getNewId();
    int insertBatch(List<UserCheck> list);
    List<UserCheck> selectUserChecksByTeamformid(Long teamformid);
    UserCheck selectUserCheckByUsercheckid(Long usercheckid);
}
