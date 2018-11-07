package team.yingyingmonster.ccbs.database.mapper.juergenie;

import org.apache.ibatis.annotations.Options;
import team.yingyingmonster.ccbs.database.bean.Teamform;

public interface JuerTeamformMapper {
    Long getNewId();
    int insert(Teamform teamform);
}
