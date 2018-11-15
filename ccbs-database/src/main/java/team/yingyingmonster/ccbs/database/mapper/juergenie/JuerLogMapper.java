package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.Log;

public interface JuerLogMapper {
    Long getNewId();
    int insert(Log log);
}
