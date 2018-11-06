package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.UserCheck;

import java.util.List;

public interface JuerUserCheckMapper {
    Long getNewId();
    int insertBatch(List<UserCheck> list);
}
