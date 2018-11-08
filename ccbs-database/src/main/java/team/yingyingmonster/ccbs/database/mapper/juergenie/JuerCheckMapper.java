package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.Check;

import java.util.List;

public interface JuerCheckMapper {
    List<Check> selectChecksByUserId(Long userid);
}
